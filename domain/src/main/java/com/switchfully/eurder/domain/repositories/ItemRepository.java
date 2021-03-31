package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.databases.ItemDatabase;
import com.switchfully.eurder.domain.elements.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ItemRepository {

    private final ItemDatabase itemDatabase;

    @Autowired
    public ItemRepository(ItemDatabase itemDatabase) {
        this.itemDatabase = itemDatabase;
    }

    public Collection<Item> getAllItems(){
        return itemDatabase.getAllItems();
    }

    public Item addItem(Item item){
        return itemDatabase.addItem(item);
    }
}
