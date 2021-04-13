package com.switchfully.eurder.api.mappers;

import com.switchfully.eurder.api.dtos.orders.CreateDtoItemGroup;
import com.switchfully.eurder.api.dtos.orders.CreateDtoOrder;
import com.switchfully.eurder.api.dtos.orders.DtoItemGroup;
import com.switchfully.eurder.api.dtos.orders.DtoOrder;
import com.switchfully.eurder.domain.elements.ItemGroup;
import com.switchfully.eurder.domain.elements.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderMapper.class);

    public DtoOrder changeOrderToDtoOrder(Order order) {
        LOGGER.info("Returning a DtoOrder based on Order with id " + order.getId());
        return new DtoOrder().setId(order.getId()).setItemGroups(transformItemGroupToDtoItemGroup(order.getOrderItems()));
    }

    public Order changeDtoOrdertoOrder(CreateDtoOrder dtoOrder) {
        LOGGER.info("Returning an Order based on a DtoOrder");
        return new Order(transformChangeDtoItemGroupToItemGroup(dtoOrder.getOrderItems()));
    }

    public List<DtoOrder> changeListOfOrdersToDtoOrders(List<Order> ordersToChange) {
        LOGGER.info("Returning all Orders in the form of DtoOrders");
        return ordersToChange.stream().map(order -> changeOrderToDtoOrder(order)).collect(Collectors.toList());
    }

    private List<ItemGroup> transformChangeDtoItemGroupToItemGroup(List<CreateDtoItemGroup> createDtoItemGroupListToChange){
        return createDtoItemGroupListToChange.stream()
                .map(createDtoItemGroup -> new ItemGroup(UUID.fromString(createDtoItemGroup.getId()), createDtoItemGroup.getAmount(), -1))
                .collect(Collectors.toList());
    }

    private List<DtoItemGroup> transformItemGroupToDtoItemGroup(List<ItemGroup> itemGroups){
        return itemGroups.stream()
                .map(itemGroup -> new DtoItemGroup()
                        .setId(itemGroup.getItemId())
                        .setAmount(itemGroup.getAmount())
                        .setShippingDate(itemGroup.getShippingDate()))
                .collect(Collectors.toList());
    }

}

