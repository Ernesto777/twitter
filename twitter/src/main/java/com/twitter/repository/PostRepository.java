package com.twitter.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.twitter.domain.Post;
import com.twitter.domain.User;

public interface PostRepository extends CrudRepository<Post,Long> 
{
	//List<Post> findTop5ByUserNameOrderByIdDesc(String userName);
	
	@Query("SELECT NEW Post(p.user, p.descriptionPost, p.createdAt) "
			+ "FROM Post p WHERE p.user.id IN :ids ORDER BY p.createdAt DESC")
	List<Post> findFirst10(@Param("ids") List<Long> ids, Pageable pageable);
	
	/*@Query("SELECT NEW Post(p.user.id, p.descriptionPost, p.createdAt) "
			+ "FROM Post p WHERE p.user.id IN :ids ORDER BY p.createdAt DESC")
	List<Post> findFirst10(@Param("ids") List<Long> ids);*/
	
	/*@Query(value= "SELECT NEW Post(p.id_user, p.descriptionPost, p.createdAt) "
			+ "FROM Post p WHERE p.user.id IN :ids ORDER BY p.createdAt DESC LIMIT 10", nativeQuery = true)
	List<Post> findLast10(@Param("ids") List<Long> ids); */
	
}