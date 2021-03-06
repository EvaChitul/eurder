package com.switchfully.eurder.domain.databases;

import com.switchfully.eurder.domain.elements.Item;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ItemDatabase {

    public static final int INCREASE_STOCK_NUMBER = 1;
    private final Map<UUID, Item> items = new HashMap<>();


    public Collection<Item> getAllItems(){
        return items.values();
    }

    public Item addItem(Item item){
        if (itemAlreadyInDatabase(item)) throw new IllegalArgumentException("Item with ID" + item.getId() + "already in system. Cannot add again");
        items.put(item.getId(), item);
        return items.get(item.getId());
    }

    private boolean itemAlreadyInDatabase(Item item) {
        return items.containsValue(item);
    }
}
