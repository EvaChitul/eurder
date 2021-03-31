package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.databases.ItemDatabase;
import com.switchfully.eurder.domain.elements.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    @Test
    void whenAddingAnItem_theSizeOfTheRepositoryIncreasesBy1(){
        Item firstItem = new Item("first", "first here", 10, 3);
        ItemRepository repository = new ItemRepository(new ItemDatabase());
        repository.addItem(firstItem);
        Assertions.assertEquals(1, repository.getAllItems().size());
    }

    @Test
    void whenAddingAnItemThatAlreadyExists_thenThrowIllegalArgumentException(){
        Item firstItem = new Item("first", "first here", 10, 3);
        Item secondItem = new Item("first", "second here", 10, 5);

        ItemRepository repository = new ItemRepository(new ItemDatabase());
        repository.addItem(firstItem);
        Assertions.assertThrows(IllegalArgumentException.class, () -> repository.addItem(secondItem));
    }

    @Test
    void whenAddingAnItemThatAlreadyExists_thenNumberOfItemsDoesNotIncrease(){
        Item firstItem = new Item("first", "first here", 10, 3);
        Item secondItem = new Item("first", "second here", 10, 5);

        ItemRepository repository = new ItemRepository(new ItemDatabase());
        repository.addItem(firstItem);

        try {
            repository.addItem(secondItem);
        } catch (IllegalArgumentException exception){};

        Assertions.assertEquals(1, repository.getAllItems().size() );
    }

}