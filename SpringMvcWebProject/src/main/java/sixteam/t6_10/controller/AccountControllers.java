package sixteam.t6_10.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sixteam.t6_10.model.Account;
import sixteam.t6_10.model.AccountService;

@Controller
public class AccountControllers {

	@Autowired
	private AccountService accountService;

	@GetMapping("goBackIndex.controller")
	public String goBackIndex() {
		return "index-background.jsp";
	}
	
	// 注意
	@GetMapping("t6_10_showAll.controller")
	public String showAllAccount(Model m) {
		List<Account> accounts = accountService.showAllAccount();
		m.addAttribute("accounts", accounts);
		return "t6_10/allAccounts";
	}

	@GetMapping("t6_10_toAddAccount.controller/{id}")
	public String toAddAccount(@PathVariable("id") int id, Model m) {
		Account account = new Account(id);
		m.addAttribute("account", account);
		System.out.println(account + "<-新增的編號");
		return "t6_10/addAccounts";
	}

	@GetMapping("/t6_10_delAccount.controller/{id}")
	public String deleteAccount(@PathVariable("id") int accountId) {
		accountService.removeAccount(accountId);
		System.out.println("刪除完成");
		return "redirect:/t6_10_showAll.controller";
	}

	// 改改看 //
	@GetMapping("t6_10_toUpdateAccount.controller/{id}")
	public String showAccount(@PathVariable("id") int id, Model m) {
		Account account = accountService.showAccount(id);
		m.addAttribute("account", account);
		return "t6_10/updateAccount";
	}

	@PostMapping("t6_10_doUpdateAccount.controller")
	public String updateAccount(@RequestParam("id") Integer id, @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("photo") MultipartFile photo, Model m) {
		System.out.println("執行updateAccount");
		String type = photo.getContentType();
		long size = photo.getSize();
		Account aBean = accountService.showAccount(id);
		if ((type.equals("image/jpeg") || type.equals("image/png")) && size != 0) {
			Blob image;
			try {
				image = fileToBlob(photo);
				aBean.setImage(image);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		}
		aBean.setAccount(account);
		aBean.setPassword(password);
		accountService.modify(aBean);
		List<Account> list = accountService.showAllAccount();
		m.addAttribute("accounts", list);
		return "t6_10/allAccounts";
	}

	@PostMapping("/t6_10_doAddAccount.controller")
	public String processAction(@RequestParam("id") Integer id, @RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("photo") MultipartFile photo, Model m)
			throws IOException {
		String type = photo.getContentType();
		long size = photo.getSize();

		if ((type.equals("image/jpeg") || type.equals("image/png")) && size != 0) {
			Blob image;
			try {
				image = fileToBlob(photo);
				accountService.add(id, account, password, image);
			} catch (IOException | SQLException e) {
				System.out.println("自訂 檔案錯誤");
				e.printStackTrace();
			}
		} else {

			String path = "C:\\springMVC\\SpringMvcWebProject\\src\\main\\webapp\\t6_10_imgs\\0.png";
			size = new File(path).length();
			InputStream is = new FileInputStream(path);
			try {
				System.out.println(size);
				System.out.println(is);
				Blob image = fileToBlob(is, size);
				accountService.add(id, account, password, image);
				System.out.println("有add");
			} catch (IOException | SQLException e) {
				System.out.println("預設 檔案錯誤");
				e.printStackTrace();
			}
		}
		return "redirect:t6_10_showAll.controller";
	}

	@GetMapping("/t6_10_img.controller/{id}")
	@ResponseBody
	public byte[] processByteArrayImageAction(@PathVariable("id") int accountId, HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		Account account = accountService.showAccount(accountId);
		Blob pBlob = account.getImage();
		InputStream binaryStream = pBlob.getBinaryStream();

		return IOUtils.toByteArray(binaryStream);
	}

	/*
	 * ============================================== 
	 * 方法區 ^^
	 * ==============================================
	 */

	public Blob fileToBlob(MultipartFile photo) throws IOException, SQLException {
		InputStream is = photo.getInputStream();
		long size = photo.getSize();
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

}
