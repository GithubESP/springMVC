package sixteam.t6_14.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.sql.rowset.serial.SerialBlob;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sixteam.t6_14.model.Actives;
import sixteam.t6_14.service.ActiveService;

@Controller
@RequestMapping("/actives")
public class ActiveController {
//	@Autowired
//	private ActiveService activeService;
//@PostMapping
//	public Actives save(@RequestBody Actives active) {
//
//		Actives result = activeService.save(active);
//		return result;
//
//	}
//@DeleteMapping("/{id}")
//	public Boolean delete(@PathVariable Integer id) {
//
//		Boolean result = activeService.delete(id);
//		return result;
//	}
//@PutMapping
//	public Actives update(@RequestBody Actives active) {
//
//		Actives result = activeService.update(active);
//		return result;
//
//	}
//@GetMapping
//	public List<Actives> findAll() {
//		List<Actives> active = activeService.findAll();
//		return active;
//	}
//@GetMapping("/{id}")
//	public Actives findById(@PathVariable Integer id) {
//		Actives active = activeService.findById(id);
//		return active;
//	}
@Autowired
private ActiveService activeService;

@PostMapping
public String save(@ModelAttribute("active") Actives actives) {
	Actives result = activeService.save(actives);
	return "t6_14/jsp/actives";
	
}
@DeleteMapping("/{id}")
public String delete(@PathVariable Integer id) {
	
	Boolean result = activeService.delete(id);
	return "t6_14/jsp/actives";
}
@PutMapping
public String update(@ModelAttribute Actives active) {
	
	Actives result = activeService.update(active);
	return "t6_14/jsp/actives";
	
}
@GetMapping
public ModelAndView findAll(Model model) {
	List<Actives> actives = activeService.findAll();
	model.addAttribute("actives",actives);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("/t6_14/jsp/actives");
	return mav;
//	return "t6_14/jsp/actives";
}
//@GetMapping("/{id}")
//public String findById(@PathVariable Integer id) {
//	Actives active = activeService.findById(id);
//	return active;
//}




//public void toImg() {
//	OutputStream os = null;
//    InputStream is = null;
//    Blob blob = null;
//    try {
//        // 讀取瀏覽器傳送來的主鍵
//        String id = req.getParameter("id");
//        // 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
//        int nId = 0;
//        try {
//            nId = Integer.parseInt(id);
//        } catch(NumberFormatException ex) {
//            ;
//        }
//        
// 
//       
//         Actives	bean = activeService.findById(nId); ///findById
//
//
//        
//        if (bean != null) {
//            blob = bean.getActiveImg();
//            System.out.println("圖片"+nId+" 大小 : "+blob.length());
//            if (blob != null) {
//                is = blob.getBinaryStream();
//
//            }
//        }
//        // 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)
//        resp.setContentType("jpg/png");//"jpg/png"
////取得能寫出非文字資料的OutputStream物件
//        os = resp.getOutputStream();
//        // 由InputStream讀取位元組，然後由OutputStream寫出
//        int len = 0;
//        byte[] bytes = new byte[8192];
//        while ((len = is.read(bytes)) != -1) {
//            os.write(bytes, 0, len);
//        }
//        log.info("送出圖片, id=" + id);
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally{
//        if (is != null) is.close();
//        if (os != null) os.close();
//
//    }
//}
//}




private Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
	byte[] b = new byte[(int) size];
	SerialBlob sb = null;
	is.read(b);
	sb = new SerialBlob(b);
	return sb;
}


//
//@RequestMapping("/hel")
//public String hello() {
//	return"success";
//}

@RequestMapping("/hel")
public ModelAndView hello() {
ModelAndView mav = new ModelAndView();
mav.setViewName("/t6_14/backjsp/NewFile");
return mav;
}









}
