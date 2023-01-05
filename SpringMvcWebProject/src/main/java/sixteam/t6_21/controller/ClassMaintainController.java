package sixteam.t6_21.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sixteam.model.Picture;
import sixteam.t6_21.Dao.ClassService;
import sixteam.t6_21.model.ClassBean;


@Controller
public class ClassMaintainController {
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping(path="/t6_21ClassMaintain.controller")
	public String processAction(Model m) {
		
		List<ClassBean> classlist = classService.selectAll();
		m.addAttribute("classList",classlist);
		return "t6_21/classMaintainList";
	}
	
	@GetMapping("/t6_21insertClass.controller")
	public String processMainAction() {
		return "t6_21/ClassInsert";
	}
	
	@PostMapping("/insertClass.controller")
	@ResponseBody
	public String processAction(@RequestParam("name") String name, @RequestParam("uploadFile") MultipartFile mf, 
            @RequestParam("teacher") String teacher) throws IOException {
		
		String fileName = mf.getOriginalFilename();
		System.out.println("fileName1:" + fileName);
		
		String saveFileDir ="C:/sixteam/SpringMvcWebProject/src/main/webapp/WEB-INF/sixteam/t6_21/images";
		File saveFilePath = new File(saveFileDir,fileName);
		
		byte[] b = mf.getBytes();
		mf.transferTo(saveFilePath);
		
		if(fileName != null && fileName.length()!=0) {
			
			
			saveClass(name,b,fileName,teacher);
		}
		
		return "index-background";
	}
	
	private void saveClass(String className, byte[] b,String classPictureName,String teacherName) {
		ClassBean cBean = new ClassBean(className,b,classPictureName,teacherName);	
		classService.insert(cBean);
	}
	
	@RequestMapping("/t6_21images.controller/{classPictureName}")
	@ResponseBody
	public byte[] processByteArrayImageAction(@PathVariable("classPictureName") String classPictureName,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/sixteam/t6_21/images/"+classPictureName);
		return IOUtils.toByteArray(in);
	}
	
//	@DeleteMapping("/t6_21deleteClass.controller/{classId}") 
//	@ResponseBody
//	public String processDeleteAction(@PathVariable("classId") int classId) {
//		
//	}

}

