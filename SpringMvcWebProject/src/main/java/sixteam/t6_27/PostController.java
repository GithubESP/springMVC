package sixteam.t6_27;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/CRUD.controller")
public class PostController {
	@Autowired
	private PostService pService;

	// 新增頁面
	@GetMapping("/t6_27addPage.controller/{postId}")
	public String processMainAction(@PathVariable("postId") int postId, Model m) {
		Post post = new Post();
		m.addAttribute("post", post);
		return "t6_27AddPost";
	}

	// 新增
	@PostMapping("/t6_27add.controller/{postId}")
	public String InsertPeopleController(HttpServletRequest request, @RequestParam("postId") Integer postId,
			@RequestParam("postTitle") String postTitle, @RequestParam("postDate") String postDate,
			@RequestParam("uploadFile") MultipartFile mf, @RequestParam("postContent") String postContent,
			@RequestParam("postLike") String postLike, @RequestParam("postDislike") String postDislike,
			@RequestParam("postComment") String postComment, Model m) throws IOException {
		String filename = mf.getOriginalFilename();
		byte[] b = mf.getBytes();

		Post post = new Post();
		if (filename != null && filename.length() != 0) {
			post.setPicture(b);
		}
		post.setPostTitle(postTitle);
		post.setPostDate(postDate);
		post.setPostLike(postLike);
		post.setPostDislike(postDislike);
		post.setPostContent(postContent);
		post.setPostComment(postComment);
		post.setPicture(b);
		post.setFilename(filename);

		pService.add(post);

		m.addAttribute("postBean", post);
		return "/t6_27AddOK";
	}

	// 刪除
	@GetMapping("/t6_27delete.controller/{postId}")
	public String processDeleteAction(@PathVariable("postId") int postId) {
		Post post = pService.findById(postId);
		System.out.println(post.toString());
		pService.delete(post);
		return "/t6_27DeleteOK";
	}

	// 修改
	@PostMapping("/t6_27update.controller/{postId}")
	public String UpdatePeopleController(HttpServletRequest request, @RequestParam("postId") Integer postId,
			@RequestParam("postTitle") String postTitle, @RequestParam("postDate") String postDate,
			@RequestParam("uploadFile") MultipartFile mf, @RequestParam("postContent") String postContent,
			@RequestParam("postLike") String postLike, @RequestParam("postDislike") String postDislike,
			@RequestParam("postComment") String postComment, Model m) throws IOException {
		String filename = mf.getOriginalFilename();
		byte[] b = mf.getBytes();

		Post post = pService.findById(postId);
		if (filename != null && filename.length() != 0) {
			post.setPostTitle(postTitle);
			post.setPostDate(postDate);
			post.setPostLike(postLike);
			post.setPostDislike(postDislike);
			post.setPostContent(postContent);
			post.setPostComment(postComment);
			post.setPicture(b);
			post.setFilename(filename);
			return "/t6_27UpdateOK";
		}
		return null;
	}

	// 查Id
	@GetMapping("/t6_27findById.controller")
	public Post findById(@PathVariable int postId) {
		Post post = pService.findById(postId);
		return post;
	}

	// 查全部
	@GetMapping("/t6_27show.controller")
	public String findAll(Model m) {
		List<Post> postlist = pService.findAll();
		m.addAttribute("postlist", postlist);
		return "t6_27FindAll";
	}

	// 查圖片
	@RequestMapping("/t6_27img.controller/{postId}")
	@ResponseBody
	public byte[] processByteArrayImageAction(@PathVariable("postId") int postId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Post post = pService.findById(postId);
		byte[] picbyte = post.getPicture();
		InputStream is = new ByteArrayInputStream(picbyte);

		return IOUtils.toByteArray(is);
	}

}
