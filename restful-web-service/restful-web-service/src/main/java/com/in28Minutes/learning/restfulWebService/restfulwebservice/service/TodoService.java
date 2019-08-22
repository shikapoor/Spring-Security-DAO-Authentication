package com.in28Minutes.learning.restfulWebService.restfulwebservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.dto.TodoDTO;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.entity.Todo;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.mapper.TodoMapper;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.repository.TodoJPARepository;



@Service
public class TodoService {
	
	@Autowired
	TodoMapper todoMapper;
	
	@Autowired
	TodoJPARepository todoJPARepository;

	static ArrayList<TodoDTO> todosList = new ArrayList<TodoDTO>();
	static int taskIdCntr = 0;
	static
	{
		todosList.add(new TodoDTO(++taskIdCntr, "Learning Swimming 1234", new Date(), false));
		todosList.add(new TodoDTO(++taskIdCntr, "Learning Angular", new Date(), false));
		todosList.add(new TodoDTO(++taskIdCntr, "Learning Spring Boot", new Date(), false));
		todosList.add(new TodoDTO(++taskIdCntr, "Learning Hibernate", new Date(), false));
		todosList.add(new TodoDTO(++taskIdCntr, "Learning Microservice", new Date(), false));
		todosList.add(new TodoDTO(++taskIdCntr, "Learning Integration", new Date(), false));
	}
	
	
	public List<TodoDTO> getAllTodos()
	{
		List<Todo> todos = todoJPARepository.findAll();
		return todoMapper.toTodoDTOs(todos);
	}
	
	public boolean deleteTodo(Integer taskID)
	{
		Optional<TodoDTO> matchingObject = todosList.stream().
			    filter(p -> p.getTaskId() == taskID).findFirst();
		
		TodoDTO todoTask = matchingObject.orElse(null);
		
		
		if(todoTask!=null)
		{
			todosList.remove(todoTask);
			return true;
		}
		
			return false;
		
	}
	
	public boolean updateTodo(TodoDTO task)
	{
		Optional<TodoDTO> matchingObject = todosList.stream().filter(p -> p.getTaskId() == task.getTaskId()).findFirst();
		TodoDTO todoTask = matchingObject.orElse(null);
		
		if(todoTask != null)
		{
			Collections.replaceAll(todosList, todoTask, task);
			return true;
		}
		return false;
	}
	
	
	public boolean createTodo(TodoDTO task)
	{
		if(task.getTaskId() == -1)
		{
			todosList.add(new TodoDTO(++taskIdCntr, task.getName(), task.getTargetDate(), task.isComplete()));
			return true;
		}
		return false;
		
	}
}
