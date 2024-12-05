package com.bbar.memo.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbar.memo.post.domain.Post;
import com.bbar.memo.post.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/list-view")
	public String MemoList(Model model) {
		
		List<Post> memoList = postService.getPostList();
		
		model.addAttribute("memoList", memoList);
		
		return "post/list";
	}
	
	@GetMapping("/create-view")
	public String createMemo() {
		return "post/input";
	}
	
	@GetMapping("/detail-view")
	public String MemoInfo(Model model) {
		
		List<Post> memoList = postService.getPostList();
		
		model.addAttribute("memoList", memoList);
		
		return "post/info";
	}
}
