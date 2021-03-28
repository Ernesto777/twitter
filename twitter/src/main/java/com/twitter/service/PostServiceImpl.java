package com.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.domain.Post;
import com.twitter.domain.User;
import com.twitter.repository.PostRepository;
import com.twitter.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService 
{

	private PostRepository postRepo;
	private UserRepository userRepo;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepo, UserRepository userRepo)
	{
		this.postRepo= postRepo;
		this.userRepo= userRepo;
	}
	
	@Override
	public Post newPost(Post post) 
	{
		Post postSaved;
		User user;
		
		user= userRepo.getByUserName(post.getUser().getUserName());
		
		Post checkedPost= new Post(user,post.getDescriptionPost()," ",null);
		
		postSaved= postRepo.save(checkedPost);
		
		return postSaved;
	}

}
