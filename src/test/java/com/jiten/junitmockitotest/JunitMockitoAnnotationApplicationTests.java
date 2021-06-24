package com.jiten.junitmockitotest;

import com.jiten.junitmockitotest.services.ExternalServiceStub;
import com.jiten.junitmockitotest.services.IExternalService;
import com.jiten.junitmockitotest.services.ITodoService;
import com.jiten.junitmockitotest.services.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.*;

// STUB is the implementation of interface which will retrun dummy/static data
// WHat if stub needs to return different records OR empty data for different tests
// STUB class will keep growing with different if/else & difficult to maintain
// If new methods are added in interface then stubs also needs to be updated

// Mocks can be dynamically created from code
// You can verify method codes
// You can setup class to return some hard coded value

@ExtendWith(MockitoExtension.class)
class JunitMockitoAnnotationApplicationTests {

    @Mock
    IExternalService externalServiceMock;

    // MOCKITO needs to know which concrete class type
    @InjectMocks
    TodoService todoService;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
    }

     @Test
    @DisplayName("Using mock ")
    void testRetrieveTodosUsingMock() {

        when(externalServiceMock.getTodos(anyString())).
                thenReturn(Arrays.asList("Spring MVC MOCK","Spring Core MOCK", "Spring Cloud MOCK","Java MOCK",
                        "Postgres MOCK","JDBC MOCK"));



        List<String> todos = todoService.getTodos("spring");

        assertEquals(3,todos.size());

    }

    @Test
    @DisplayName("when empty list is returned from external service, todos should be empty")
    void testRetrieveTodosUsingMock2() {

        when(externalServiceMock.getTodos(anyString())).
                thenReturn(Arrays.asList());

        List<String> todos = todoService.getTodos("spring");

        assertEquals(0,todos.size());

    }



}
