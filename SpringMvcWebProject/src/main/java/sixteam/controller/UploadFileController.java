package sixteam.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sixteam.model.Picture;
import sixteam.model.PictureService;

@Controller
public class UploadFileController {
	
	@GetMapping("/uploadfilemain.controller")
	public String processMainAction() {
		return "uploadFile";
	}
	@PostMapping("/upload.controller")
	@ResponseBody
	public String processAction(@RequestParam("myFiles") MultipartFile mf) throws IOException {
		String fileName = mf.getOriginalFilename();
		System.out.println("fileName1:" + fileName);
		
		String saveFileDir ="c:/temp/upload";
		File saveFilePath = new File(saveFileDir,fileName);
		System.out.println(saveFilePath);
		mf.transferTo(saveFilePath);
		byte[] b = mf.getBytes();
		if(fileName != null && fileName.length()!=0) {
			
			savePicture(fileName,b);
		}
		
		return "saveFilePath:" + saveFilePath;
	}
	
	@Autowired
	private PictureService pService;
	
	private void savePicture(String fileName, byte[] b) {
		Picture p1 = new Picture(fileName, b);	
		pService.insert(p1);
	}
}

