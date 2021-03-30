package com.switchfully.eurder.api.dtos;


public class CreateDtoCustomer {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    public CreateDtoCustomer setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CreateDtoCustomer setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CreateDtoCustomer setEmail(String email){
        this.email = email;
        return this;
    }

    public CreateDtoCustomer setAddress(String address){
        this.address = address;
        return this;
    }

    public CreateDtoCustomer setPhone (String phone){
        this.phone = phone;
        return this;
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
