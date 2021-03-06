package com.switchfully.eurder.domain.elements;

import java.util.Objects;
import java.util.UUID;

public class Item {

    private final String name;
    private final String description;
    private final double price;
    private final int stock;
    private final UUID id;

    public Item(String name, String description, double price, int stock) {
        if (!validateItemInput(name, description, price, stock))
            throw new IllegalArgumentException(" Cannot create item, invalid input provided");
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.id = UUID.randomUUID();
    }

    public boolean validateItemInput(String name, String description, double price, int stock){
        return name != null && !name.equals("") && !name.equals(" ") &&
                description != null && !description.equals("") && !description.equals(" ") &&
                price > 0 && stock >= 0;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
