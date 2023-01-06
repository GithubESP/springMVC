package sixteam.t6_06.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sixteam.t6_06.model.TempleBean;
import sixteam.t6_06.model.TempleService;


@Controller
public class TempleController {
	
	@Autowired
	private TempleService tService;
	
	
	//查詢Postman測試成功
	@GetMapping("/templeFindByIdAction/{templeId}")
	@ResponseBody
	public String templeFindByIdAction(@PathVariable("templeId") String templeId) {
		TempleBean tmpb = tService.findById(templeId);
		
		if(tmpb!=null) {
			return "Result:" + tmpb.getTempleId() +" " + tmpb.getTempleName()+" "+ tmpb.getDeitiesName() + " " + tmpb.getAdministrative()
			 + " "+tmpb.getAddress()+" " + tmpb.getRegister()+" "+tmpb.getSect()+" "+tmpb.getPhone()+" "+tmpb.getPrincipal()+" "+tmpb.getOther()+" "+tmpb.getWGS84X()
			 +" "+tmpb.getWGS84Y()+" "+tmpb.getUniformnumbers();
		}
		
		return "no Result";
	}
	
	
	
	
	
	//刪除Postman測試成功
	@DeleteMapping("/templeProfilesDeleteAction/{templeId}")
	@ResponseBody
	public String templeProfilesDeleteAction(@PathVariable("templeId")String templeId) {
		tService.deleteTemple(templeId);
		return "Delete OK";
	}
	
}
