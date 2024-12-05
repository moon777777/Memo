package com.bbar.memo.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbar.memo.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	

}
