package com.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.domain.User;
import com.twitter.repository.FollowerRepository;
import com.twitter.repository.UserRepository;

@Service
public class FollowerServiceImpl implements FollowerService
{

	private FollowerRepository followerRepo;
	private UserRepository userRepo;
	
	@Autowired
	public FollowerServiceImpl(FollowerRepository followerRepo, UserRepository userRepo)
	{
		this.followerRepo= followerRepo;
		this.userRepo= userRepo;
	}
	
	@Override
	public List<User> unFollowUsers(Long idFollower) 
	{
		List<User> unFollowUsers;
		
		List<Long> followUser= followerRepo.findByIdFollower(idFollower);
		
		if(followUser.isEmpty())
		{
			unFollowUsers= (List<User>) userRepo.findAll();
		}
		
		else
		{
			unFollowUsers= userRepo.findByIdUser(followUser);
		}
		
		return unFollowUsers;
	}

}
