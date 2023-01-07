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

//@WebServlet("/accountLogin")
@Controller
public class AccountmanagerLoginController {

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
			errors.put("name", "帳號為必填");
		}
		
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "密碼為必填");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		boolean status = aService.checkLogin(new AccountManager(user, pwd));
		
		if(status) {
//			m.addAttribute("user", user);
//			m.addAttribute("pwd", pwd);
			System.out.println("=========Success===========");
			return "redirect:showAllAccountControllersafe";
		}
		
		errors.put("msg", "請輸入正確的帳號或密碼");		
		return "loginSystem";
//		if(manager!=null) {
//			HttpSession session=req.getSession();
//			session.setAttribute("manager", manager);
//			resp.sendRedirect(req.getContextPath()+"/showAllAccountControllersafe");
//		}else {
//			resp.sendRedirect(req.getContextPath()+"/t6_10/accountLogin.html"); // 如果是空返回原畫面
//		}
			
		}
	}


