package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.items.CreateDtoItem;
import com.switchfully.eurder.api.dtos.items.DtoItem;
import com.switchfully.eurder.api.mappers.ItemMapper;
import com.switchfully.eurder.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoItem addItem(@RequestBody CreateDtoItem item){
        LOGGER.info("Adding an item");
        return itemMapper.changeItemToDtoItem(itemService.addItem(itemMapper.changeDtoItemToItem(item)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DtoItem> getAllItems(){
        LOGGER.info("Getting all the items");
        return itemMapper.changeCollectionOfItemsToListOfDtoItems(itemService.getAllItems());
    }
}
