package com.in28Minutes.learning.restfulWebService.restfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.in28Minutes.learning.restfulWebService.restfulwebservice.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query("select u from UserEntity u where u.username= :name")
	public UserEntity getUserByUsername(@Param("name") String username);
}
