package com.bbar.memo.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbar.memo.post.domain.Post;
import com.bbar.memo.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/post")
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/list-view")
	public String MemoList(Model model
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> memoList = postService.getPostList(userId);
	
		model.addAttribute("memoList", memoList);
		
		return "post/list";
	}
	
	@GetMapping("/create-view")
	public String createMemo() {
		return "post/input";
	}
	
	@GetMapping("/detail-view")
	public String MemoInfo(@RequestParam("id") int id
			, Model model) {
		
		Post memo = postService.getPost(id);
		
		model.addAttribute("memo", memo);
		    
		    // 상세 정보를 보여줄 페이지로 리턴합니다.
		 return "post/detail";
	}
}
