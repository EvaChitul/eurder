package com.switchfully.eurder.domain.elements;

import java.util.UUID;

public class Customer {

    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phone;

    public Customer(String firstName, String lastName, String email, String address, String phone) {
        if (!validateCustomerInput(firstName, lastName, email, address, phone))
            throw new IllegalArgumentException("Cannot create customer, invalid input provided");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.id = UUID.randomUUID();
    }

    public boolean validateCustomerInput(String firstName, String lastName, String email, String address, String phone) {
        return firstName != null && !firstName.equals("") &&
                lastName != null && !lastName.equals("") &&
                email != null && !email.equals("") && email.matches(EMAIL_FORMAT) &&
                address != null && !address.equals("") && phone != null && !phone.equals("");
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

    public UUID getId() {
        return id;
    }
}
