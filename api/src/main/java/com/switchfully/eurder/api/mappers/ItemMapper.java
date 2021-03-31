package com.switchfully.eurder.api.mappers;

import com.switchfully.eurder.api.dtos.items.CreateDtoItem;
import com.switchfully.eurder.api.dtos.items.DtoItem;
import com.switchfully.eurder.domain.elements.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(ItemMapper.class);

    public DtoItem changeItemToDtoItem(Item item){
        LOGGER.info("Returning a DtoItem based on Item with id " + item.getId());
        return new DtoItem()
                .setId(item.getId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setStock(item.getStock());
    }

    public Item changeDtoItemToItem(CreateDtoItem dtoItem){
        LOGGER.info("Returning an Item based on a DtoItem");
        return new Item(dtoItem.getName(), dtoItem.getDescription(), dtoItem.getPrice(), dtoItem.getStock());
    }

    public List<DtoItem> changeCollectionOfItemsToListOfDtoItems(Collection<Item> itemsToChange){
        LOGGER.info("Returning all Items in the form of DtoItems");
        return itemsToChange.stream().map(item -> changeItemToDtoItem(item)).collect(Collectors.toList());
    }
}
