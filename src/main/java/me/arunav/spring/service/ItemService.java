package me.arunav.spring.service;

import me.arunav.spring.data.ItemRepository;
import me.arunav.spring.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemService {

    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItem() {
        return new Item(1, "Item", 10.5, 50);
    }

    public List<Item> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(item -> new Item(item.getId(), item.getName(), item.getPrice(), item.getQuantity(),
                        item.getPrice() * item.getQuantity()))
                .collect(Collectors.toList());
    }
}
