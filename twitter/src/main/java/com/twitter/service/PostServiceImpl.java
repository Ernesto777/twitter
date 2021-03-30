package com.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.twitter.domain.Post;
import com.twitter.domain.User;
import com.twitter.repository.FollowerRepository;
import com.twitter.repository.PostRepository;
import com.twitter.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService 
{

	private PostRepository postRepo;
	private UserRepository userRepo;
	private FollowerRepository followerRepo;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepo, UserRepository userRepo, FollowerRepository followerRepo)
	{
		this.postRepo= postRepo;
		this.userRepo= userRepo;
		this.followerRepo= followerRepo;
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

	@Override
	public List<Post> last10PostFollowedUser(String userName) 
	{
		User user;
		List<Post> userPosts;
				
		user= userRepo.getByUserName(userName);
				
		List<Long> followUser= followerRepo.findByIdFollower(user.getId());
		
		//get last 10 posts of followed users
		Pageable top10 = PageRequest.of(0, 10);

		userPosts= postRepo.findFirst10(followUser,top10);
		
		return userPosts;
	}
}
