package com.switchfully.eurder.domain.elements;

import java.util.*;

public class Order {

    private final UUID id;
    private final List<ItemGroup> orderItems;

    public Order(List<ItemGroup> orderItems) {
        this.id = UUID.randomUUID();
        this.orderItems = new ArrayList<>();
    }

    public Order addItemGroupToOrder(ItemGroup itemGroup){
        this.orderItems.add(itemGroup);
        return this;
    }

    public UUID getId() {
        return id;
    }

    public List<ItemGroup> getOrderItems() {
        return orderItems;
    }
}
