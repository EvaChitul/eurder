package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.items.CreateDtoItem;
import com.switchfully.eurder.api.mappers.ItemMapper;
import com.switchfully.eurder.domain.databases.ItemDatabase;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    private ItemService itemService;
    private ItemMapper itemMapper;
    private ItemController itemController;

    @BeforeEach
    public void init(){
        itemService = new ItemService(new ItemRepository(new ItemDatabase()));
        itemMapper = new ItemMapper();
        itemController = new ItemController(itemService, itemMapper);
    }

    @Test
    void whenGettingAllItems_theCorrectNumberIsReturned(){
        CreateDtoItem item = new CreateDtoItem().setName("test").setDescription("test this").setPrice(10).setStock(1);
        itemMapper.changeItemToDtoItem(itemService.addItem(itemMapper.changeDtoItemToItem(item)));
        Assertions.assertEquals(1, itemController.getAllItems().size());
    }

}