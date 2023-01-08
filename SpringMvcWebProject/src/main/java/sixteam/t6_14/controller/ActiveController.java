package sixteam.t6_14.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sixteam.t6_14.model.Actives;
import sixteam.t6_14.service.ActiveService;
//@RestController
@Controller
@RequestMapping("/actives")
@MultipartConfig
public class ActiveController {
	

@Autowired
private ActiveService activeService;

@PostMapping("/add")
public ModelAndView save(@RequestParam("name") String name,@RequestParam("img") byte[] img,@RequestParam("description") String description
,@RequestParam("start") Date start,@RequestParam("end") Date end,@RequestParam("location") String location,@RequestParam("host") String host
,ModelAndView mav,MultipartFile mf)  {
	System.out.println("------------");
	String fileName = mf.getOriginalFilename();

	try {
		byte[] b = mf.getBytes();
	} catch (IOException e) {
		System.out.println("有問題");
		e.printStackTrace();
	}
	
	if (fileName != null && fileName.length() != 0) {
		Actives actives=new Actives(name,img,description,start,end,location,host);
		System.out.println(actives);
		activeService.save(actives);
	}
	mav.setViewName("redict:/t6_14/mainactive");
	return mav;
	
}
@DeleteMapping("/{id}")
public String delete(@PathVariable Integer id) {
	
	Boolean result = activeService.delete(id);
	return "t6_14/jsp/actives";
}
@PutMapping
public String update(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("img") byte[] img,@RequestParam("description") String description
		,@RequestParam("start") Date start,@RequestParam("end") Date end,@RequestParam("location") String location,@RequestParam("host") String host) {
	Actives actives=new Actives(id,name,img,description,start,end,location,host);
	activeService.update(actives);
	return "t6_14/jsp/actives";
	
}
@GetMapping
public ModelAndView findAll(Model model) {
	List<Actives> actives = activeService.findAll();
	model.addAttribute("actives",actives);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("t6_14/mainactive");
	return mav;
}

//讀圖片
@RequestMapping("/toImg/{activeID}")
@ResponseBody
public byte[] toImg(@PathVariable("activeID") int activeID, HttpServletRequest request,
		HttpServletResponse response) throws IOException {
	Actives actives = activeService.findById(activeID);
	byte[] picturebyte = actives.getActiveImg();
	InputStream is = new ByteArrayInputStream(picturebyte);

	return IOUtils.toByteArray(is);

}

//跳轉到修改頁面的jsp
@GetMapping("/updateView/{activeID}")
public ModelAndView toUpdateAddView(@PathVariable ("activeID") Integer activeID,Model model,ModelAndView mav) {
	Actives result=	activeService.findById(activeID);
	model.addAttribute("actives",result);
	mav.setViewName("t6_14/activeupdate");
	return mav;
}

//跳轉道新增頁面的jsp
@GetMapping("/addView")
public ModelAndView toAddView(ModelAndView mav) {
	mav.setViewName("t6_14/addactive");
	return mav;
}


}
//轉json
//@Autowired
//private ActiveService activeService;
//@PostMapping
//public Actives save(@RequestBody Actives active) {
//
//	Actives result = activeService.save(active);
//	return result;
//
//}
//@DeleteMapping("/{id}")
//public Boolean delete(@PathVariable Integer id) {
//
//	Boolean result = activeService.delete(id);
//	return result;
//}
//@PutMapping
//public Actives update(@RequestBody Actives active) {
//
//	Actives result = activeService.update(active);
//	return result;
//
//}
//@GetMapping
//public List<Actives> findAll() {
//	List<Actives> active = activeService.findAll();
//	return active;
//}
//@GetMapping("/{id}")
//public Actives findById(@PathVariable Integer id) {
//	Actives active = activeService.findById(id);
//	return active;
//}


//crud