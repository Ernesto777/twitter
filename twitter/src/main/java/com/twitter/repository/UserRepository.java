package com.twitter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.twitter.domain.User;

public interface UserRepository extends CrudRepository<User,Long> 
{

	Optional<String> findByUserName(String username);
	User getByUserName(String username);
	
	@Query("SELECT new User(u.id, u.userName) FROM com.twitter.domain.User u WHERE u.id NOT IN :ids")
	List<User> findByIdUser(@Param("ids") List<Long> ids);

	User getById(Long idUser);
	
	//List<User> findByIdUser(List<Long> id);

	Optional<String> findByEmail(String email);
	//boolean findByEmail(String email);
}
