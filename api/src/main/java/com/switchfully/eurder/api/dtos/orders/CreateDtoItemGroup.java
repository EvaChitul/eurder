package com.switchfully.eurder.api.dtos.orders;

public class CreateDtoItemGroup {

    private String id;
    private int amount;

    public CreateDtoItemGroup setAmount(int amount){
        this.amount = amount;
        return this;
    }

    public CreateDtoItemGroup setId(String id){
        this.id = id;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }
}
