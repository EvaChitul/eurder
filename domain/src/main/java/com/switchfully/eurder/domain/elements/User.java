package com.switchfully.eurder.domain.elements;

import java.util.UUID;

public class User {

    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phone;
    private final Roles role;

    public User(String firstName, String lastName, String email, String address, String phone, Roles role) {
        if (!validateUserInput(firstName, lastName, email, address, phone, role))
            throw new IllegalArgumentException("Cannot create User, illegal input provided");
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public boolean validateUserInput(String firstName, String lastName, String email, String address, String phone, Roles role) {
        return  firstName != null && !firstName.equals("") &&
                lastName != null && !lastName.equals("") &&
                email != null && !email.equals("") && email.matches(EMAIL_FORMAT) &&
                address != null && !address.equals("") && phone != null && !phone.equals("") &&
                role != null;
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

    public Roles getRole() {
        return role;
    }
}
