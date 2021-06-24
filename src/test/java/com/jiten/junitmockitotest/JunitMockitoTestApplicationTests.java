package com.jiten.junitmockitotest;

import com.jiten.junitmockitotest.services.ExternalServiceStub;
import com.jiten.junitmockitotest.services.IExternalService;
import com.jiten.junitmockitotest.services.ITodoService;
import com.jiten.junitmockitotest.services.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

// STUB is the implementation of interface which will retrun dummy/static data
// WHat if stub needs to return different records OR empty data for different tests
// STUB class will keep growing with different if/else & difficult to maintain
// If new methods are added in interface then stubs also needs to be updated

// Mocks can be dynamically created from code
// You can verify method codes
// You can setup class to return some hard coded value

class JunitMockitoTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Using stub ")
    void testRetrieveTodosUsingStub() {
        IExternalService externalServiceStub = new ExternalServiceStub();
        ITodoService todoService = new TodoService(externalServiceStub);

        List<String> todos = todoService.getTodos("spring");

        assertEquals(3,todos.size());

    }



    @Test
    @DisplayName("Using mock ")
    void testRetrieveTodosUsingMock() {

        IExternalService externalServiceMock = mock(IExternalService.class);

        when(externalServiceMock.getTodos(anyString())).
                thenReturn(Arrays.asList("Spring MVC MOCK","Spring Core MOCK", "Spring Cloud MOCK","Java MOCK",
                        "Postgres MOCK","JDBC MOCK"));

        ITodoService todoService = new TodoService(externalServiceMock);

        List<String> todos = todoService.getTodos("spring");

        assertEquals(3,todos.size());

    }

    @Test
    @DisplayName("when empty list is returned from external service, todos should be empty")
    void testRetrieveTodosUsingMock2() {

        IExternalService externalServiceMock = mock(IExternalService.class);

        when(externalServiceMock.getTodos(anyString())).
                thenReturn(Arrays.asList());

        ITodoService todoService = new TodoService(externalServiceMock);

        List<String> todos = todoService.getTodos("spring");

        assertEquals(0,todos.size());

    }

    @Test
    @DisplayName("verify getTodos is called on IExternalService")
    void testRetrieveTodosUsingMock3() {

        IExternalService externalServiceMock = mock(IExternalService.class);

        when(externalServiceMock.getTodos(anyString())).
                thenReturn(Arrays.asList());

        ITodoService todoService = new TodoService(externalServiceMock);

        List<String> todos = todoService.getTodos("spring");


        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(externalServiceMock, Mockito.times(1)).getTodos(anyString());
        verify(externalServiceMock).getTodos(argumentCaptor.capture());

        assertTrue(argumentCaptor.getValue().equalsIgnoreCase("spring"));




    }

    @Test
    @DisplayName("List add Using mock ")
    void testListAddUsingMock() {

        List<String> mockList = mock(List.class);
        mockList.add("First");
        when(mockList.get(0)).thenReturn("Mockito");
        when(mockList.get(1)).thenReturn("JCG");
        assertEquals("Mockito", mockList.get(0));
        assertEquals("JCG", mockList.get(1));




    }

}
