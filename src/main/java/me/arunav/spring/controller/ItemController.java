package me.arunav.spring.controller;

import me.arunav.spring.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item getDummyItem() {
        return new Item(1, "Item", 10.5, 50);
    }
}