package com.in28Minutes.learning.restfulWebService.restfulwebservice.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.dto.TodoDTO;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.entity.Todo;

import org.springframework.stereotype.Component;

@Mapper(componentModel="spring")
public interface TodoMapper {
	
	TodoDTO toTodoDTO(Todo todoObj);
	
	Todo toToDo(TodoDTO todoDtoObj);
	
	List<TodoDTO> toTodoDTOs(List<Todo> todos );

}
