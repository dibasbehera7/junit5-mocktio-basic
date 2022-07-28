package com.dibasb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dibasb.api.TodoService;
import com.dibasb.business.TodoBusinessImpl;

public class TodoBusinessImplMockitoInejctMocksTest {

	@Mock
	private TodoService todoServiceMock;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
//	todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	

	@BeforeEach
	public void createMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testRetriveTodosRelatedToSpring_usingMock() {

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		when(todoServiceMock.retrieveTodos("Dibas")).thenReturn(todos);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dibas");

		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void testRetriveTodosRelatedToSpring_usingEmptyList() {

		List<String> todos = Arrays.asList();
		
		when(todoServiceMock.retrieveTodos("Dibas")).thenReturn(todos);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dibas");

		assertEquals(0, filteredTodos.size());

	}
}
