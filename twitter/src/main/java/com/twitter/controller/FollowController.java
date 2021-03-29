package com.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.domain.User;
import com.twitter.service.FollowerService;

@RestController
@RequestMapping("/follow")
public class FollowController 
{
	private FollowerService followerService;
	
	@Autowired
	public FollowController(FollowerService followerService)
	{
		this.followerService= followerService;
	}
	
    @GetMapping
    ResponseEntity<List<User>> getUsers(@RequestParam("userId") Long userId) 
    {
    	List<User> users = followerService.unFollowUsers(userId);
    	
    	return ResponseEntity.ok(users);
    }
}
