package sixteam.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sixteam.model.House;

@Controller
public class JsonCreateController {
	@GetMapping("/jsoncreate.controller")
	@ResponseBody
	public String processJsonAction() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("happy house");
		
		ObjectMapper om1 = new ObjectMapper();
		String jsonStr = om1.writeValueAsString(hBean1);
		
		House resultBean = om1.readValue(jsonStr, House.class);
		
		System.out.println(resultBean.getHouseid() + ":" + resultBean.getHousename());
		
		return "jsonStr:" + jsonStr;
	}
	
	@GetMapping("/jsoncreate2.controller")
	@ResponseBody
	public House processJsonAction2() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("happy house");
		return hBean1;
	}
	
	@GetMapping("/jsoncreate3.controller")
	@ResponseBody
	public ArrayList<House> processJsonAction3() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("happy house");
		
		House hBean2 = new House();
		hBean1.setHouseid(1002);
		hBean1.setHousename("fashion house");
		
		ArrayList<House> list = new ArrayList<House>();
		list.add(hBean1);
		list.add(hBean2);
		
		return list;
	}


}
