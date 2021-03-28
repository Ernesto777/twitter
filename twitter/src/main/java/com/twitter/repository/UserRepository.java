package com.twitter.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.twitter.domain.User;

public interface UserRepository extends CrudRepository<User,Long> 
{

	Optional<String> findByUserName(String username);
	User getByUserName(String username);

	Optional<String> findByEmail(String email);
	//boolean findByEmail(String email);
}
