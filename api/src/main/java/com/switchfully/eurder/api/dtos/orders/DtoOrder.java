package com.switchfully.eurder.api.dtos.orders;

import com.switchfully.eurder.domain.elements.Item;
import com.switchfully.eurder.domain.elements.ItemGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DtoOrder {

    private UUID id;
    private List<DtoItemGroup> orderItems;
    private double total_price;

    public DtoOrder setId(UUID id){
        this.id = id;
        return this;
    }

    public DtoOrder setItemGroups(List<DtoItemGroup> itemList){
        this.orderItems = itemList;
        return this;
    }

    public DtoOrder setTotal_price(double total_price) {
        this.total_price = total_price;
        return this;
    }

    public DtoOrder setOrderItems(List<DtoItemGroup> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public double getTotal_price() {
        return total_price;
    }

    public List<DtoItemGroup> getOrderItems() {
        return orderItems;
    }

    public UUID getId() {
        return id;
    }
}
