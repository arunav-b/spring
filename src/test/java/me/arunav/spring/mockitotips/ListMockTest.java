package me.arunav.spring.mockitotips;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    // Mocking the List interface in Java
    List<String> mockList = mock(List.class);

    @Test
    @DisplayName("Return a single mocked value")
    public void test_returnSingleMockedValue() {
        when(mockList.size()).thenReturn(5);
        assertEquals(5, mockList.size());
    }

    @Test
    @DisplayName("Returning different mock values")
    public void test_returnDifferentValues() {
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mockList.size());
        assertEquals(10, mockList.size());
    }

    @Test
    @DisplayName("Returning different values with parameters")
    public void test_returnWithParams() {
        when(mockList.get(0)).thenReturn("some value");
        assertEquals("some value", mockList.get(0));
        assertEquals(null, mockList.get(1));
    }

    @Test
    @DisplayName("Argument Matchers")
    public void test_returnWithGenericParams() {
        when(mockList.get(anyInt())).thenReturn("same value");
        assertEquals("same value", mockList.get(0));
        assertEquals("same value", mockList.get(-1));
        assertEquals("same value", mockList.get(23));
    }

    @Test
    @DisplayName("Verification Basics")
    // This is useful when we want to know if a particular method is called with a specific value
    public void test_verify() {

        // Let's say the following piece of code is System-Under-Test
        // This is the portion where actual code will be tested.
        // Here we are just writing our own code.
        mockList.get(0);
        mockList.get(1);

        // Verifying number of calls with a specific value
        verify(mockList).get(0); // If times is not passed, by default it is 1
        verify(mockList, times(2)).get(anyInt());
        verify(mockList, atLeast(1)).get(anyInt());
        verify(mockList, atLeastOnce()).get(anyInt());
        verify(mockList, atMost(2)).get(anyInt());
        verify(mockList, never()).get(3);
    }

    @Test
    @DisplayName("Capturing arguments passed in a method")
    public void test_argumentCapture() {

        // Let's say the following piece of code is System-Under-Test
        // This is the portion where actual code will be tested.
        // Here we are just writing our own code.
        mockList.add("Some String");

        // Declaring the instance that will capture the value passed in our object.
        // In this case the object we are referring to is a String.
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        // Captor will capture the String that is passed in the add method in the actual code
        verify(mockList).add(captor.capture());

        // Compares the actual and expected results
        assertEquals("Some String", captor.getValue());
    }

    @Test
    @DisplayName("Capturing multiple arguments passed in a method")
    public void test_multipleArgumentCapture() {

        mockList.add("Some String1");
        mockList.add("Some String2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());

        // Capturing all the values in a List
        List<String> allValues = captor.getAllValues();
        assertEquals("Some String1", allValues.get(0));
        assertEquals("Some String2", allValues.get(1));
    }

    @Test
    @DisplayName("Spying on a class")
    // A "mock" does not retain behavior (code) of the original class
    // A "spy", by default retains the behavior of the original class
    public void test_spy(){

    }
}
