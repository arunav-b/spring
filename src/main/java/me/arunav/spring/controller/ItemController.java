package me.arunav.spring.controller;

import me.arunav.spring.model.Item;
import me.arunav.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/dummy-item")
    public Item getDummyItem() {
        return new Item(1, "Item", 10.5, 50);
    }

    @GetMapping("/item")
    public Item getItemFromService() {
        return itemService.getItem();
    }

    @GetMapping("/items")
    public List<Item> getItemsFromDB(){
        List<Item> items = itemService.getItems();
        System.out.println(items);
        return items;
    }

}