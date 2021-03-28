package com.twitter.repository;

import org.springframework.data.repository.CrudRepository;

import com.twitter.domain.Post;

public interface PostRepository extends CrudRepository<Post,Long> 
{
	//List<Post> findTop5ByUserNameOrderByIdDesc(String userName);
}
