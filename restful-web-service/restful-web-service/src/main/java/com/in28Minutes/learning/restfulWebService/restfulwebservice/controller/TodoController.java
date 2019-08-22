package com.in28Minutes.learning.restfulWebService.restfulwebservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.dto.TodoDTO;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.service.TodoService;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {
	
	@Autowired
	TodoService todosService;
	
	
	@RequestMapping(path="/todo/getMessage", method = RequestMethod.GET)
	public ResponseEntity<TodoDTO> getMessage()
	{
		return  new ResponseEntity<TodoDTO>(new TodoDTO(2,"Hello World from server!!",null,false), HttpStatus.OK) ;
	}

	@RequestMapping( method = RequestMethod.GET,path="/todo/get")
	public List<TodoDTO> getAllTodos()
	{
		return todosService.getAllTodos();
	}
	
	@DeleteMapping("/todo/delete/{taskID}")
	public ResponseEntity<Boolean> deleteTodo(@PathVariable Integer taskID ){
		return new ResponseEntity(todosService.deleteTodo(taskID), HttpStatus.OK);
	}
	
	@PutMapping("/todo/update/{taskId}")
	public ResponseEntity<Boolean> updateTodoTask(@PathVariable Integer taskId, @RequestBody TodoDTO todoTask)
	{
		return new ResponseEntity<Boolean>(todosService.updateTodo(todoTask), HttpStatus.OK);
	}
	
	@PostMapping("/todo/create")
	public ResponseEntity<Boolean> createTodoTask(@RequestBody TodoDTO todoTask)
	{
		return new ResponseEntity<Boolean>(todosService.createTodo(todoTask),HttpStatus.OK);
	}
	
	
} 
