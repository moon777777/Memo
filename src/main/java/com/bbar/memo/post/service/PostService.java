package com.bbar.memo.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bbar.memo.post.domain.Post;
import com.bbar.memo.post.repository.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public boolean addPost(int userId, String title, String contents) {
		
		Post post = Post.builder()
		.userId(userId)
		.title(title)
		.contents(contents)
		.build();
		
		try {
			Post result = postRepository.save(post);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
		  
	public List<Post> getPostList() {
		return postRepository.findAll();
	}

}
