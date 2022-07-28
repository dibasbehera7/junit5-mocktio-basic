package com.dibasb;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void letsMockListSizeMethod() {
		List<?> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List<?> list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(0)).thenReturn("Dibas");
		assertEquals("Dibas", list.get(0));
		assertNull(list.get(1));
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("Dibas");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("Dibas", list.get(0));
		assertEquals("Dibas", list.get(1));
	}

	@Test
	public void letsMockList_throwAnException() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Error occurred"));
		assertThrows(RuntimeException.class, () -> list.get(0));
	}

	@Test
	public void bddAliases_UsingGivenWillReturn() {
		List<String> list = mock(List.class);

		// given
		given(list.get(Mockito.anyInt())).willReturn("in28Minutes");

		// then	
		assertThat("in28Minutes", is(list.get(0)));
		assertThat("in28Minutes", is(list.get(0)));
	}

}
