package com.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.twitter.domain.Follower;

public interface FollowerRepository extends CrudRepository<Follower,Long> 
{
	@Query(value = "select distinct(id_user) from follower where id_follower <> ?1", 
		   nativeQuery = true)
	List<Long> findByIdFollower(Long idFollower);
}
