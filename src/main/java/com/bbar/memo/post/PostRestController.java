package com.bbar.memo.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbar.memo.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	private PostService postService;
	
	public PostRestController(PostService postService ) {
		this.postService = postService;
	}
	
	@PostMapping("/create")
	public Map<String, String> createMemo(
			@RequestParam("title") String title
			, @RequestParam("contents") String contents
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId"); //업캐스팅 되어서 저장된 형태 그래서 다운캐스팅해서 사용
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(postService.addPost(userId, title, contents)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
}
