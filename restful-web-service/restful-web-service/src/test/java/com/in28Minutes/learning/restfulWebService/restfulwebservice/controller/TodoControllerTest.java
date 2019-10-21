package com.in28Minutes.learning.restfulWebService.restfulwebservice.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.service.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoControllerTest {

	@InjectMocks
	TodoController controller;
	
	@Mock
	TodoService todosService;
	
	@Test(expected = NullPointerException.class)
	public void getAllTodos() {
		when(todosService.getAllTodos()).thenReturn(new ArrayList<>());
		
		assertNotNull(controller.getAllTodos());
	}
}
