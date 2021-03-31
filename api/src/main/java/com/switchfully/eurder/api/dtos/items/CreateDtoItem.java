package com.switchfully.eurder.api.dtos.items;

public class CreateDtoItem {

    private String name;
    private String description;
    private double price;
    private int stock;

    public CreateDtoItem setName(String name){
        this.name = name;
        return this;
    }

    public CreateDtoItem setDescription(String description){
        this.description = description;
        return this;
    }

    public CreateDtoItem setPrice(double price){
        this.price = price;
        return this;
    }

    public CreateDtoItem setStock(int stock){
        this.stock = stock;
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
}
