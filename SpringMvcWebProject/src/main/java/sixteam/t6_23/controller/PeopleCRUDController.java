package sixteam.t6_23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import sixteam.t6_23.service.PeopleService;
import sixteam.t6_23.service.impl.PeopleServiceImpl;

@Controller
public class PeopleCRUDController {
	
//	@Autowired
//	private PeopleServiceImpl pService;
	
	@Autowired
	private PeopleService pService;
	
	public PeopleCRUDController() {
		this.pService=new PeopleServiceImpl();
	}
	
	@GetMapping("/selectaction.controller")
	public String processMainAction() {
		return "t6_23/UserSelect";
	}
	
	

}
