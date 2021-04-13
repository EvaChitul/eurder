package com.switchfully.eurder.api.dtos.orders;

import com.switchfully.eurder.domain.elements.ItemGroup;

import java.util.List;

public class CreateDtoOrder {

    private List<CreateDtoItemGroup> orderItems;

    public CreateDtoOrder setItems(List<CreateDtoItemGroup> itemList){
        this.orderItems = itemList;
        return this;
    }

    public List<CreateDtoItemGroup> getOrderItems() {
        return orderItems;
    }
}
