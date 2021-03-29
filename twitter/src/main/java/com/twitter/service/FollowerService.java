package com.twitter.service;

import java.util.List;

import com.twitter.domain.User;

public interface FollowerService 
{
	List<User> unFollowUsers(Long idFollower);
}
