package com.jiten.junitmockitotest;

import com.jiten.junitmockitotest.services.ExternalServiceStub;
import com.jiten.junitmockitotest.services.IExternalService;
import com.jiten.junitmockitotest.services.ITodoService;
import com.jiten.junitmockitotest.services.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Arrays;
import java.util.List;

public class ListMockTests {

    @Test
    @DisplayName("when size method is called it should return 2")
    void test() {
        List<String> list = mock(List.class);

        list.add("A");
        list.add("B");
        list.add("C");
        when(list.size()).thenReturn(2);
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("when size method is called it should return 2 & second time it's called should retrun 3")
    void test2() {
        List<String> list = mock(List.class);

        list.add("A");
        list.add("B");
        list.add("C");
        when(list.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, list.size());
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("when get method is called should retrun value jiten")
    void test3() {
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("jiten");
        assertEquals("jiten", list.get(0));
    }

    @Test
    @DisplayName("when get method is called multiple times should retrun value jiten & for non stubbed it should return null")
    void test4() {
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("jiten");
        assertEquals("jiten", list.get(0));
        assertEquals(null, list.get(1));
    }

    @Test
    @DisplayName("when get method is without set up should return null")
    void test5() {
        List<String> list = mock(List.class);
        assertEquals(null, list.get(0));
        assertEquals(null, list.get(1));
    }

    @Test
    @DisplayName("when get method is called with anyInt setup should return anyint")
    void test6() {
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenReturn("anyint");
        assertEquals("anyint", list.get(0));
        assertEquals("anyint", list.get(1));
        assertEquals("anyint", list.get(-100));
    }

    @Test
    @DisplayName("when get method is called with exception setup should throw exception")
    void test7() {
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("invalid call"));
        RuntimeException ex = assertThrows(RuntimeException.class, () -> list.get(0));
        assertTrue(ex.getMessage().equalsIgnoreCase("invalid call"));
    }
}

