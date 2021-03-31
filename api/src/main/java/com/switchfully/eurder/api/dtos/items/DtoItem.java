package com.switchfully.eurder.api.dtos.items;

import java.util.UUID;

public class DtoItem {

    private String name;
    private String description;
    private double price;
    private int stock;
    private UUID id;

    public DtoItem setName(String name){
        this.name = name;
        return this;
    }

    public DtoItem setDescription(String description){
        this.description = description;
        return this;
    }

    public DtoItem setPrice (double price){
        this.price = price;
        return this;
    }

    public DtoItem setStock(int stock){
        this.stock = stock;
        return this;
    }

    public DtoItem setId(UUID id){
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public UUID getId() {
        return id;
    }
}
