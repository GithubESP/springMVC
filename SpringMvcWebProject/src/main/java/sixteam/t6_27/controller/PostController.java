package sixteam.t6_27.controller;

import java.io.ByteArrayInputStream;
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

import sixteam.t6_27.model.Post;
import sixteam.t6_27.model.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService pService;

	// GO新增頁面
	@GetMapping("/t6_27addPage.controller")
	public ModelAndView toAddView(ModelAndView mav) {
		mav.setViewName("t6_27/t6_27AddPage");
		return mav;
	}

	// 新增
	@PostMapping("/t6_27add.controller")
	public ModelAndView InsertPostController(@RequestParam("postTitle") String postTitle,
			@RequestParam("postDate") String postDate, @RequestParam("img") MultipartFile mf,
			@RequestParam("postContent") String postContent, @RequestParam("postLike") String postLike,
			@RequestParam("postDislike") String postDislike, @RequestParam("postComment") String postComment,
			ModelAndView mav) throws IOException {

		System.out.println("------------");

		String filename = mf.getOriginalFilename();
		byte[] b = mf.getBytes();
		if (filename != null && filename.length() != 0) {
			Post post = new Post(postTitle, postDate, postContent, postLike, postDislike, postComment, b);
			System.out.println(post);
			pService.add(post);
		}
		mav.setViewName("redirect:/t6_27show.controller");

		return mav;
	}

	// 刪除
	@GetMapping("/t6_27delete.controller/{postId}")
	public ModelAndView processDeleteAction(@PathVariable("postId") Integer postId) {
		Post result = pService.findById(postId);
		System.out.println(result.toString());
		pService.delete(result);
		return new ModelAndView("redirect:/t6_27show.controller");
	}

	// GO修改頁面
	@GetMapping("/t6_27updatePage.controller/{postId}")
	public ModelAndView UpdatePage(@PathVariable("postId") Integer postId, Model model, ModelAndView mav) {
		Post result = pService.findById(postId);
		model.addAttribute("bean", result);
		mav.setViewName("t6_27/t6_27UpdatePage");
		return mav;
	}

	// 修改
	@PostMapping("/t6_27update.controller")
	public String UpdatePostController(@RequestParam("postId") Integer postId,
			@RequestParam("postTitle") String postTitle, @RequestParam("postDate") String postDate,
			@RequestParam("img") MultipartFile mf, @RequestParam("postContent") String postContent,
			@RequestParam("postLike") String postLike, @RequestParam("postDislike") String postDislike,
			@RequestParam("postComment") String postComment, Model m) throws IOException {

		System.out.println("------------");

		String filename = mf.getOriginalFilename();
		byte[] b = mf.getBytes();
		if (filename != null && filename.length() != 0) {
			Post result = new Post();
			System.out.println(result);
			result.setPostId(postId);
			result.setPostTitle(postTitle);
			result.setPostDate(postDate);
			result.setPicture(b);
			result.setPostContent(postContent);
			result.setPostLike(postLike);
			result.setPostDislike(postDislike);
			result.setPostComment(postComment);

			pService.update(result);
		}
		List<Post> postlist = pService.findAll();
		m.addAttribute("postlist", postlist);

		return ("redirect:/t6_27show.controller");
	}

	// 查全部
	@GetMapping("/t6_27show.controller")
	public String findAll(Model m) {
		List<Post> postlist = pService.findAll();
		m.addAttribute("postlist", postlist);
		return "t6_27/t6_27FindAll";
	}

	// 查圖片
	@RequestMapping("/t6_27img.controller/{postId}")
	@ResponseBody
	public byte[] processByteArrayImageAction(@PathVariable("postId") Integer postId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Post post = pService.findById(postId);
		byte[] picbyte = post.getPicture();
		InputStream is = new ByteArrayInputStream(picbyte);
		System.out.println(postId);
		System.out.println(is);
		System.out.println(picbyte);
		return IOUtils.toByteArray(is);
	}

}
