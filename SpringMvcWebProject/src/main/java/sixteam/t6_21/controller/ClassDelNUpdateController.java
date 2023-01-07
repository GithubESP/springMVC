package sixteam.t6_21.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sixteam.t6_21.Dao.ClassService;
import sixteam.t6_21.model.ClassBean;

@Controller
public class ClassDelNUpdateController {
	@Autowired
	private ClassService classService;
	
	@GetMapping("/t6_21deleteClass.controller/{classId}") 
	public ModelAndView processDeleteAction(@PathVariable("classId") int classId) {
		ClassBean cBean = classService.findById(classId);
		System.out.println(cBean.toString());
		classService.delete(cBean);
		return new ModelAndView("redirect:/t6_21ClassMaintain.controller");
	}
	
	@GetMapping("/t6_21preupdateClass.controller/{classId}")
	public String processMainAction(@PathVariable("classId") int classId,Model m) {
		ClassBean cBean = classService.findById(classId);
		m.addAttribute("classBean",cBean);
		System.out.println(cBean);
		return "t6_21/classUpdateList";

	}
	
	@PostMapping("/t6_21updateClass.controller")
	public String processUpdateAction(@RequestParam("id") int classId,@RequestParam("name") String name, @RequestParam("uploadFile") MultipartFile mf, 
            @RequestParam("teacher") String teacher,Model m) throws IOException {
		
		String fileName = mf.getOriginalFilename();
		byte[] b = mf.getBytes();
		
		ClassBean cBean = classService.findById(classId);
		if(fileName != null && fileName.length()!=0) {
			cBean.setClassName(name);
			cBean.setClassPicture1(b);
			cBean.setClassPictureName(fileName);
			cBean.setClassTeacherName(teacher);
			classService.update(cBean);
			}else {
				cBean.setClassName(name);
				cBean.setClassTeacherName(teacher);
				updateClass(name,teacher);
			}
		
		return "t6_21/classUpdateList";

	}
	private void updateClass(String className,String teacherName) {
		ClassBean cBean = new ClassBean();
		cBean.setClassName(className);
		cBean.setClassTeacherName(teacherName);
		classService.update(cBean);

	}
}
