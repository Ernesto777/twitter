package com.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.domain.Post;
import com.twitter.domain.User;
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
    
    @GetMapping
    ResponseEntity<List<Post>> getLast10Posts(@RequestParam("userName") String userName )
    {
		List<Post> posts;
    	
		posts= postService.last10PostFollowedUser(userName);
    	
    	return ResponseEntity.ok(posts);
    }
}
