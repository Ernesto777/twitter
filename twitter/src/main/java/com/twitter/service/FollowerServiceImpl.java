package com.twitter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.domain.Follower;
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
	public List<User> notFollowedUsers(Long idFollower) 
	{
		List<User> notFollowedUsers;
		
		//Retrieve followed users
		List<Long> followUser= followerRepo.findByIdFollower(idFollower);
		
		//if nobody is followed yet, retrieve all of users
		if(followUser.isEmpty())
		{
			notFollowedUsers= (List<User>) userRepo.findAll();
		}
		
		else
		{
			//Retrieve notfollowed users
			notFollowedUsers= userRepo.findByIdUser(followUser);
		}
		
		return notFollowedUsers;
	}
	

	@Override
	public User selectedUserFollow(Long userIdFollow, Long userIdFollower) 
	{
		
		List<Long> followUser= followerRepo.findByIdFollower(userIdFollower);
		
		User followed = userRepo.getById(userIdFollow);
		User follower = userRepo.getById(userIdFollower);

		for (Long temp : followUser) 
        {
        	if(temp == userIdFollow)
        		return follower;
        	        		
        }
		
		Follower newFollower= new Follower(followed, follower.getId());
		
		followerRepo.save(newFollower);
		
		return followed;
	}

}
