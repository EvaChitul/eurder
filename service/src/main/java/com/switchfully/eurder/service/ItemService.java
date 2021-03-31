package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.elements.Item;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item){
        return itemRepository.addItem(item);
    }

    public Collection<Item> getAllItems(){
        return itemRepository.getAllItems();
    }
}
