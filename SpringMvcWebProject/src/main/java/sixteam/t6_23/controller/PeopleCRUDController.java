package sixteam.t6_23.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sixteam.t6_23.bean.PeopleBean_23;
import sixteam.t6_23.service.GlobalService;
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
	
	@GetMapping("/selectaction.controller2")
	public String processMainAction2(Model m) {
		List<PeopleBean_23> beans = pService.selectAll();
		m.addAttribute("peopleBeans", beans);
		return "t6_23/ShowUserSelect";
	}
	
	@PostMapping("/userSelectControllersafe")
	public String showUserSelect(@RequestParam("userId") String userName, Model m) {
		List<PeopleBean_23> bean;
		if(userName.equals("")) {
			bean = pService.selectAll();
			
		}else {
			bean = pService.selectByName(userName);
		}
		m.addAttribute("peopleBeans", bean);
		return "t6_23/ShowUserSelect";
	}
	
	@GetMapping("/t6_23/controller/showPeople.do")
	public String ShowAllPeople(Model m) {
		List<PeopleBean_23> beans = pService.selectAll();
		m.addAttribute("peopleBeans", beans);
		return "t6_23/ShowPeople";
	}	
	
	@GetMapping("/showPeopleControllersafe")
	public String ShowUpdatePeopleController(@RequestParam("id") Integer id, Model m) {
		PeopleBean_23 bean = pService.selectById(id);
		m.addAttribute("bean", bean);
		return "t6_23/ShowUpdatePeopleForm";
	}
	
	@GetMapping("/showPeopleControllersafe2")
	public String ShowPeopleController(@RequestParam("id") Integer id, Model m) {
		PeopleBean_23 bean = pService.selectById(id);
		m.addAttribute("bean", bean);
		return "t6_23/ShowUserSelectForm";
	}
	
	@GetMapping("/removePeople.do")
	public String DeletePeopleController(@RequestParam("id") Integer id, Model m) {
		pService.delete(id);
		
		List<PeopleBean_23> beans = pService.selectAll();
		m.addAttribute("peopleBeans", beans);
		return "t6_23/ShowPeople";
	}
	
//	@GetMapping(path = "/toImages", produces = "text/plain;chartset=UTF-8")
//	@ResponseBody
//	public void processButeArrayImageAction(@RequestParam("id") Integer id, HttpServletResponse res) throws IOException {
//		PeopleBean_23 bean = pService.selectById(id);
//		OutputStream os = null;
//		  InputStream is = null;
//		  Blob blob = null;
//		  try {
//			   if (bean != null) {
//			    blob = bean.getImages();
//			    if (blob != null) {
//			     is = blob.getBinaryStream();
//			    }
//			   }
//			   // 設定輸出資料的MIME型態
//			   res.setContentType("jpg/png");
//			   // 取得能寫出非文字資料的OutputStream物件
//			   os = res.getOutputStream(); 
//			   // 由InputStream讀取位元組，然後由OutputStream寫出
//			   int len = 0;
//			   byte[] bytes = new byte[8192];
//			   while ((len = is.read(bytes)) != -1) {
//			    os.write(bytes, 0, len);
//			   }
//			  } catch (SQLException e) {
//			   e.printStackTrace();
//			  } finally{
//			   if (is != null) is.close();
//			   if (os != null) os.close();
//			  }
//	}
	
	@GetMapping(path = "/toImages", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processButeArrayImageAction(@RequestParam("id") Integer id, HttpServletRequest request) throws IOException {
		PeopleBean_23 bean = pService.selectById(id);
		String images = bean.getImages();
		System.out.println("id"+id+" id2 "+bean.getUserID()+" images= " + images);
//		InputStream in = request.getServletContext().getResourceAsStream(images);
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images06.jpg");
		return IOUtils.toByteArray(in);
	}
	
	@GetMapping("/t6_23/controller/InsertPeopleForm.controller")
	public String processToInsertForm() {
		return "t6_23/InsertPeopleForm_23";
	}
	
	@PostMapping("/processpeople.controller")
	public String InsertPeopleController(HttpServletRequest request,@RequestParam("userId") Integer userid, @RequestParam("name") String name, @RequestParam("age") Integer age,@RequestParam("photo") MultipartFile mf,
			@RequestParam("gender") String sex, @RequestParam("address") String address, @RequestParam("star_sign") String star, @RequestParam("profession") String profession,
			@RequestParam("religion") String religion, @RequestParam("income") @Nullable Double income, @RequestParam("sex_in") String sex_in, @RequestParam("hobby") String hobby,
			@RequestParam("dream") String dream, @RequestParam("personality") String personality, @RequestParam("emotion") String emotion, @RequestParam("introduction") String introduction, Model m) throws IOException, ServletException, SQLException {
		
		String saveFileDir ="c:/temp/people_photo";
		File saveFilePath = new File(saveFileDir,String.valueOf(userid)+".jpg");
		String filePath = String.valueOf(saveFilePath);
		mf.transferTo(saveFilePath);
		
		PeopleBean_23 pb = new PeopleBean_23();
		pb.setUserID(userid);
		pb.setName(name);
		pb.setAge(age);
		pb.setSex(sex);
		pb.setAddress(address);
		pb.setStar(star);
		pb.setEmotion(emotion);
		pb.setProfession(profession);
		pb.setPersonality(personality);
		pb.setHobby(hobby);
		pb.setDream(dream);
		pb.setIncome(income);
		pb.setIntroduction(introduction);
		pb.setReligion(religion);
		pb.setSex_in(sex_in);
		pb.setImages(filePath);
		System.out.println("------------------");
		pService.save(pb);
		
		m.addAttribute("peopleBean", pb);
		return "t6_23/InsertPeopleSuccess";
	}
	
	@PostMapping("/updatePeopleControllersafe")
	public String UpdatePeopleController(HttpServletRequest request,@RequestParam("userId") Integer userid, @RequestParam("name") String name, @RequestParam("age") Integer age,@RequestParam("photo") MultipartFile mf,
			@RequestParam("address") String address, @RequestParam("star_sign") String star, @RequestParam("profession") String profession,
			@RequestParam("religion") String religion, @RequestParam("income") @Nullable Double income, @RequestParam("sex_in") String sex_in, @RequestParam("hobby") String hobby,
			@RequestParam("dream") String dream, @RequestParam("personality") String personality, @RequestParam("emotion") String emotion, @RequestParam("introduction") String introduction, Model m) throws IllegalStateException, IOException  {
		
		String saveFileDir ="c:/temp/people_photo";
		File saveFilePath = new File(saveFileDir,String.valueOf(userid)+".jpg");
		String filePath = String.valueOf(saveFilePath);
		mf.transferTo(saveFilePath);
		
		PeopleBean_23 pb = new PeopleBean_23();
		
		pb.setUserID(userid);
		pb.setName(name);
		pb.setAge(age);
		pb.setAddress(address);
		pb.setStar(star);
		pb.setEmotion(emotion);
		pb.setProfession(profession);
		pb.setPersonality(personality);
		pb.setHobby(hobby);
		pb.setDream(dream);
		pb.setIntroduction(introduction);
		pb.setReligion(religion);
		pb.setSex_in(sex_in);
		pb.setIncome(income);
		pb.setImages(filePath);

		pService.update(pb);
		
		
		
		
		
		
		
		
		List<PeopleBean_23> beans = pService.selectAll();
		m.addAttribute("peopleBeans", beans);
		return "t6_23/ShowPeople";
	}
		

}
