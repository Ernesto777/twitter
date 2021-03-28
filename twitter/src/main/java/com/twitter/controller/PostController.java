package com.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.domain.Post;
import com.twitter.service.PostService;

@RestController
@RequestMapping("/publications")
public class PostController 
{
	private PostService postService;
	
	@Autowired
	public PostController(PostService postService)
	{
		this.postService= postService;
	}
	
    @PostMapping
    ResponseEntity<Post> postPublication(@RequestBody Post post)
    {
    	Post postRegistered;
    	
    	postRegistered= postService.newPost(post);
    	
    	return ResponseEntity.ok(postRegistered);
    }
}
