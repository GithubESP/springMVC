package sixteam.t6_21.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sixteam.t6_21.Dao.ClassService;
import sixteam.t6_21.model.ClassBean;


@Controller
public class ClassMaintainController {
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping(path="/ClassMaintain.controller")
	public String processAction(Model m) {
		
		List<ClassBean> classlist = classService.selectAll();
		
		for(ClassBean cbBean :classlist) {
			System.out.println(cbBean.toString());
		}
		
		m.addAttribute("classList",classlist);
		return "t6_21/classMaintainList";
		
	}

}

