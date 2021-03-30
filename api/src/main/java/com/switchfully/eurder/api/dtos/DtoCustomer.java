package com.switchfully.eurder.api.dtos;

import java.util.UUID;

public class DtoCustomer {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    public DtoCustomer setId(UUID id){
        this.id = id;
        return this;
    }

    public DtoCustomer setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public DtoCustomer setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public DtoCustomer setEmail(String email){
        this.email = email;
        return this;
    }

    public DtoCustomer setAddress(String address){
        this.address = address;
        return this;
    }

    public DtoCustomer setPhone (String phone){
        this.phone = phone;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
