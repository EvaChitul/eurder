package com.switchfully.eurder.api.dtos.orders;

import java.util.UUID;

public class DtoItemGroup {

    private UUID id;
    private int amount;
    private int shippingDate;
    private double price;

    public DtoItemGroup setAmount(int amount){
        this.amount = amount;
        return this;
    }

    public DtoItemGroup setShippingDate(int date){
        this.shippingDate = date;
        return this;
    }

    public DtoItemGroup setId(UUID id){
        this.id = id;
        return this;
    }

    public DtoItemGroup setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getShippingDate() {
        return shippingDate;
    }

    public UUID getId() {
        return id;
    }
}
