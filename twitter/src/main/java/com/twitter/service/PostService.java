package com.twitter.service;

import java.util.List;

import com.twitter.domain.Post;

public interface PostService 
{
	Post newPost(Post post);
	
	List<Post> last10PostFollowedUser(String userName);

	//List<Object> last10PostFollowedUser(String userName);
}
