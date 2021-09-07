package me.arunav.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock
    Dao dao= mock(Dao.class);

    @InjectMocks
    Service service = new Service(dao);

    @Test
    @DisplayName("Calculating sum for random values")
    void random_calculateSum() {
        int[] input = new int[]{14, 4, -9, 8};
        when(dao.getAllData()).thenReturn(input);
        assertEquals(17, service.calculateSum());
    }

    @Test
    @DisplayName("Calculating sum for an empty list")
    void empty_calculateSum() {
        int[] input = new int[]{};
        when(dao.getAllData()).thenReturn(input);
        assertEquals(0, service.calculateSum());
    }

    @Test
    @DisplayName("Calculating sum for one value")
    void one_calculateSum() {
        int[] input = new int[]{14};
        when(dao.getAllData()).thenReturn(input);
        assertEquals(14, service.calculateSum());
    }
}
