package com.switchfully.eurder.domain.elements;

import java.util.*;

public class Order {

    private final List<ItemGroup> order = new ArrayList<>();

    public List<ItemGroup> getOrder() {
        return order;
    }

    public List<ItemGroup> addItemToOrder(ItemGroup itemGroup) {
        order.add(itemGroup);
        return order;
    }

}
