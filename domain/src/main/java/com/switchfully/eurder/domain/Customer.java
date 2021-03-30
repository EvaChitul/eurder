package com.switchfully.eurder.domain;

public class Customer {

    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phone;

    public Customer(String firstName, String lastName, String email, String address, String phone) {
        if (!validateCustomerInput(firstName, lastName, email, address, phone))
            throw new IllegalArgumentException("Cannot create customer, illegal input provided");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public boolean validateCustomerInput(String firstName, String lastName, String email, String address, String phone) {
        return firstName != null && !firstName.equals("") &&
                lastName != null && !lastName.equals("") &&
                email != null && !email.equals("") && email.matches(EMAIL_FORMAT) &&
                address != null && !address.equals("") && phone != null && !phone.equals("");
    }
}
