package sixteam.t6_10.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sixteam.t6_10.model.Account;
import sixteam.t6_10.model.AccountService;

@Controller
public class ShowAllAccountController {

		@Autowired
		private AccountService  accountService;
		
		// 注意
		@GetMapping(path = "showAllAccountControllersafe")
		public String showAllAccount(Model m) {
		List<Account> accounts=accountService.showAllAccount();
		m.addAttribute("accounts", accounts);
		return "showAllAccountsafe";
		}
		
		
		@GetMapping("/t6_10_addAccount.controller/{id}")
		public String processMainAction(@PathVariable("id") int id,Model m) {
			Account account = new Account(id);
			m.addAttribute("account",account);
			System.out.println(account+"新增的編號");
			return "addAccounts";
		}
		
		////
		@GetMapping("showAccountControllersafe/{id}")
		public String showAccount(@PathVariable("id") int id, Model m) {
		Account account=accountService.showAccount(id);
		m.addAttribute("account", account);
		return "updateAccount";
		}
		
		
		@PostMapping("/updateAccountControllersafe")
		public String updateAccount(@RequestParam("id") Integer id,@RequestParam("account") String account,@RequestParam("password") String password, @RequestParam("photo") MultipartFile photo, Model m) {
			System.out.println("執行updateAccount");
			String type = photo.getContentType();
			long size = photo.getSize();
			Account aBean=accountService.showAccount(id);
			if ((type.equals("image/jpeg")||type.equals("image/png")) && size != 0) {
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
			updateAccount(aBean);	//	updateAccount(aBean);
			List<Account> list = accountService.showAllAccount();
			m.addAttribute("accounts", list);
			return "showAllAccountsafe";
		}
		
		
		@PostMapping("/AddAccountControllersafe")
		public ModelAndView processAction(@RequestParam("id") Integer id, 
	            @RequestParam("account") String account,@RequestParam("password") String password, @RequestParam("photo") MultipartFile photo,Model m) throws IOException {
			String type = photo.getContentType();
			long size = photo.getSize();
			System.out.println("getBytes: "+photo.getBytes());
			System.out.println("getContentType: "+photo.getContentType());
			System.out.println("getSize: "+photo.getSize());
			System.out.println("isEmpty: "+photo.isEmpty());
			System.out.println("getInputStream: "+photo.getInputStream());
			System.out.println("getOriginalFilename: "+photo.getOriginalFilename());
			
			if ((type.equals("image/jpeg")||type.equals("image/png")) && size != 0) {
				Blob image;
				try {
					image = fileToBlob(photo);
					addAccount(id,account,password,image);
				} catch (IOException | SQLException e) {
					System.out.println("自訂 檔案錯誤");
					e.printStackTrace();
				}
			}else {
			
				String path = "C:\\springMVC\\SpringMvcWebProject\\src\\main\\webapp\\t6_10_imgs\\0.png";
				size = new File(path).length();
				InputStream is  = new FileInputStream(path);
				try {
					System.out.println(size);
					System.out.println(is);
					Blob image = fileToBlob(is,size);
					addAccount(id,account,password,image);
					System.out.println("有add");
				} catch (IOException | SQLException e) {
					System.out.println("預設 檔案錯誤");
					e.printStackTrace();
				}
			}
			return new ModelAndView("redirect:showAllAccountControllersafe");
		}
		
		@RequestMapping("/t6_10_img.controller/{id}")
		@ResponseBody
		public byte[] processByteArrayImageAction(@PathVariable("id") int accountId,HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
			Account account = accountService.showAccount(accountId);
			Blob pBlob =account.getImage();
			byte[] pBytes = pBlob.getBytes(1l, (int)pBlob.length());
			InputStream inputStream = new ByteArrayInputStream(pBytes);
			
			return IOUtils.toByteArray(inputStream);
		}
		
		
		
		/*==============================================
		 *     方法區 ^^
		 *==============================================
		 */
		
		private void addAccount(Integer id, String account, String password, Blob image) {
			Account aBean = new Account(id,account,password,image);	
			accountService.add(aBean);
			System.out.println("執行addAccount");
		}
		
		private void updateAccount(Account aBean) {
			accountService.modify(aBean);
			System.out.println("執行updateAccount");
		}
		
		public Blob fileToBlob(MultipartFile photo) throws IOException, SQLException {
			InputStream is = photo.getInputStream();
			long size = photo.getSize();
			byte[] b = new byte[(int) size];
			SerialBlob sb = null;
			is.read(b);
			sb = new SerialBlob(b);
			return sb;
		}
		
		public Blob fileToBlob(InputStream is ,long size) throws IOException, SQLException {
			byte[] b = new byte[(int) size];
			SerialBlob sb = null;
			is.read(b);
			sb = new SerialBlob(b);
			return sb;
		}
		
	
		
}
