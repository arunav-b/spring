package me.arunav.spring.controller;

import me.arunav.spring.model.Item;
import me.arunav.spring.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    @DisplayName("Get Dummy Item")
    public void test_getDummyItem() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Item\",\"price\":10.5,\"quantity\":50}"))
                .andReturn();
    }

    @Test
    @DisplayName("Get Item from ItemService")
    public void test_getItemFromItemService() throws Exception {

        // Mocking the ItemService getItem() method
        Mockito.when(itemService.getItem())
                .thenReturn(new Item(1, "Item", 10.5, 50));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, name:Item, price:10.5}"))
                .andReturn();
    }

    @Test
    @DisplayName("Get Items from ItemService fetching from DB")
    public void test_getItemsFromItemService() throws Exception {

        List<Item> items = Arrays.asList(
                new Item(1, "Item1", 10.5, 50),
                new Item(2, "Item2", 25, 20));

        Mockito.when(itemService.getItems()).thenReturn(items);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1, name:Item1, price:10.5}, {id:2, name:Item2, price:25}]"))
                .andReturn();
    }
}