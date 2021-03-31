package com.switchfully.eurder.domain.elements;

import java.util.Objects;
import java.util.UUID;

public class User {

    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Roles role;

    public User(String firstName, String lastName, String email, Roles role) {
        if (!validateUserInput(firstName, lastName, email, role))
            throw new IllegalArgumentException("Cannot create User, illegal input provided");
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public boolean validateUserInput(String firstName, String lastName, String email, Roles role) {
        return  firstName != null && !firstName.equals("") &&
                lastName != null && !lastName.equals("") &&
                email != null && !email.equals("") && email.matches(EMAIL_FORMAT) &&
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

    public Roles getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
