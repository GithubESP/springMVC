package sixteam.t6_10.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		@RequestMapping("/t6_10_img.controller/{id}")
		@ResponseBody
		public byte[] processByteArrayImageAction(@PathVariable("id") int accountId,HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
			Account account = accountService.showAccount(accountId);
			Blob pBlob =account.getImage();
			byte[] pBytes = pBlob.getBytes(1l, (int)pBlob.length());
			InputStream inputStream = new ByteArrayInputStream(pBytes);
			
			return IOUtils.toByteArray(inputStream);
		}
		
		
	
		
		@GetMapping("/t6_10_addAccount.controller/{id}")
		public String processMainAction(@PathVariable("id") int id,Model m) {
			Account account = new Account(id);
			m.addAttribute("account",account);
			System.out.println(account+"新增的編號");
			return "addAccounts";

		}
		
}
