package sixteam.t6_06.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sixteam.t6_06.model.TempleBean;
import sixteam.t6_06.model.TempleService;


@Controller
public class TempleController {
	
	@Autowired
	private TempleService tService;
	
	//查詢jsp可以跑了
//	@RequestMapping(path = "/templeFindByIdAction",method = RequestMethod.POST)
//	public String templeFindByIdAction(String templeId,Model m) {
//		TempleBean tmpb = tService.findById(templeId);
//		ArrayList<TempleBean> list = new ArrayList<TempleBean>();
//		list.add(tmpb);
//		m.addAttribute("tmp",list);
//		return "ContralData";
//	}
	//傳導到搜尋id的網頁
	@RequestMapping(path = "/temple.controller",method = RequestMethod.GET)
	public String processMainAction() {
		
		return "t6_06/FindTemple";
	}
	
//	---------------------------------------------------------------------------------------
	//查詢 
	@PostMapping("/templeFindByIdAction")
	public String templeFindByIdAction(@RequestParam("templeId") String templeId,Model m2) {
		TempleBean tmpb = tService.findById(templeId);
		ArrayList<TempleBean> list = new ArrayList<TempleBean>();
		list.add(tmpb);
		m2.addAttribute("tmp", list);
		return "t6_06/ContralData";
	}
	
	//新增資料
	@PostMapping("/insertTempleData")
	public String insertTempleDataAction(@RequestParam("templeName") String templeName,@RequestParam("deitiesName") String deitiesName,
								   @RequestParam("administrative") String administrative,@RequestParam("address")String address,
							       @RequestParam("register") String register,@RequestParam("sect") String sect, @RequestParam("phone") String phone, 
								   @RequestParam("principal") String principal, @RequestParam("other") String other, @RequestParam("wGS84X") Double wGS84X,
								   @RequestParam("wGS84Y") Double wGS84Y, @RequestParam("uniformnumbers") int uniformnumbers) {
		TempleBean tmpb = new TempleBean();
		tmpb.setTempleName(templeName);
		tmpb.setDeitiesName(deitiesName);
		tmpb.setAdministrative(administrative);
		tmpb.setAddress(address);
		tmpb.setRegister(register);
		tmpb.setSect(sect);
		tmpb.setPhone(phone);
		tmpb.setPrincipal(principal);
		tmpb.setOther(other);
		tmpb.setWGS84X(wGS84X);
		tmpb.setWGS84Y(wGS84Y);
		tmpb.setUniformnumbers(uniformnumbers);
		
		tService.insertTemple(tmpb);
		
		return "t6_06/FindTemple";
		
	}
	
	//更改
	@PostMapping("/updateTempleDataAction")
	public String updateTempleDataAction(@RequestParam("templeId") String templeId,@RequestParam("templeName") String templeName,@RequestParam("deitiesName") String deitiesName,
			   @RequestParam("administrative") String administrative,@RequestParam("address")String address,
		       @RequestParam("register") String register,@RequestParam("sect") String sect, @RequestParam("phone") String phone, 
			   @RequestParam("principal") String principal, @RequestParam("other") String other, @RequestParam("wGS84X") Double wGS84X,
			   @RequestParam("wGS84Y") Double wGS84Y, @RequestParam("uniformnumbers") int uniformnumbers) {
		TempleBean tmpb = new TempleBean(templeId,templeName,deitiesName,administrative,address,register,sect,phone,principal,other,wGS84X,wGS84Y,uniformnumbers);
		tService.updateOneTemple(tmpb);
		return "t6_06/FindTemple";
	}
	
	//刪除
	@PostMapping("/templeDeleteAction")
	public String templeDeleteAction(@RequestParam("templeId")String templeId) {
		System.out.println(templeId);
		tService.deleteTemple(templeId);
		return "t6_06/FindTemple";
	}
	
	@RequestMapping(path = "/templeSellectAllAction",method = RequestMethod.POST)
	public String templeSellectAllAction(Model m2) {
		List<TempleBean> beans = tService.sellectAll();
		
		m2.addAttribute("tmp", beans);
		return "t6_06/SellectAll";
	}
	
}
