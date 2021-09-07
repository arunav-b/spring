package me.arunav.spring.service;

import me.arunav.spring.data.ItemRepository;
import me.arunav.spring.model.Item;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository repository;
    @InjectMocks
    private ItemService itemService;

    @Test
    @DisplayName("Calculating sum for random values")
    void test_totalInGetItems() {
        // This is needed to initialize the @Mock and @InjectMocks annotations
        MockitoAnnotations.openMocks(this);

        List<Item> items = Arrays.asList(
                new Item(1, "Item1", 10, 50),
                new Item(2, "Item2", 20, 20));

        when(repository.findAll()).thenReturn(items);

        List<Item> actualItems = itemService.getItems();
        assertEquals(500, actualItems.get(0).getTotal());
        assertEquals(400, actualItems.get(1).getTotal());
    }
}
