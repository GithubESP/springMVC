package sixteam.t6_21.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sixteam.t6_21.Dao.ClassService;
import sixteam.t6_21.model.ClassBean;

@Controller
public class ClassMaintainController {

	@Autowired
	private ClassService classService;

	@RequestMapping(path = "/t6_21ClassMaintain.controller")
	public String processAction(Model m) {

		List<ClassBean> classlist = classService.selectAll();
		m.addAttribute("classList", classlist);
		return "t6_21/classMaintainList";
	}

	@GetMapping("/t6_21insertClass.controller")
	public String processMainAction() {
		return "t6_21/ClassInsert";
	}

	@PostMapping("/insertClass.controller")
	public ModelAndView processAction(@RequestParam("name") String name, @RequestParam("uploadFile") MultipartFile mf,
			@RequestParam("teacher") String teacher, Model m) throws IOException {

		String fileName = mf.getOriginalFilename();

		byte[] b = mf.getBytes();

		if (fileName != null && fileName.length() != 0) {
			saveClass(name, b, fileName, teacher);
		}

		return new ModelAndView("redirect:/t6_21ClassMaintain.controller");
	}

	private void saveClass(String className, byte[] b, String classPictureName, String teacherName) {
		ClassBean cBean = new ClassBean(className, b, classPictureName, teacherName);
		classService.insert(cBean);
	}

	@RequestMapping("/t6_21images.controller/{classId}")
	@ResponseBody
	public byte[] processByteArrayImageAction(@PathVariable("classId") int classId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ClassBean cBean = classService.findById(classId);
		byte[] picturebyte = cBean.getClassPicture1();
		InputStream is = new ByteArrayInputStream(picturebyte);

		return IOUtils.toByteArray(is);

	}


}
