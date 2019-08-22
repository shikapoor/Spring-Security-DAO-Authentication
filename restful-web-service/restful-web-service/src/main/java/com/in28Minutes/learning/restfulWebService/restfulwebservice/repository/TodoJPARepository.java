package com.in28Minutes.learning.restfulWebService.restfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.entity.Todo;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long>{
	
	@Query("select t from Todo t where t.name= :name")
	public Todo getUserByName(@Param("name") String name);

}
