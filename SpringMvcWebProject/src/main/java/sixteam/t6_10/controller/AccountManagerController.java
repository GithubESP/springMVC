package sixteam.t6_10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sixteam.t6_10.model.AccountManager;
import sixteam.t6_10.model.AccountManagerService;

@Controller

public class AccountManagerController {
	
	@Autowired
	private AccountManagerService aService;
	
	@RequestMapping(path = "/loginsystemmain.controller", method = RequestMethod.GET)
	public String processMainAction() {
		return "loginSystem";
	}

	@RequestMapping(path = "/checklogin.controller", method = RequestMethod.POST)
	public String processAction(@RequestParam("userName") String user, @RequestParam("userPwd") String pwd, Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(user==null || user.length()==0) {
			errors.put("name", "請輸入帳號 name is required");
		}
		
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "請輸入密碼 password is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		boolean status = aService.checkLogin(new AccountManager(user,pwd));
		
		if (status) {
			m.addAttribute("user",user);
			m.addAttribute("pwd",pwd);
			return "loginSuccess";
		}
		
		errors.put("msg", "請輸入正確的帳號或密碼");
		
		return "loginSystem";
	}

}