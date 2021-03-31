package com.switchfully.eurder.api.dtos.users;

import com.switchfully.eurder.domain.elements.Roles;

public class CreateDtoUser {

    private String firstName;
    private String lastName;
    private String email;
    private Roles role;

    public CreateDtoUser setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CreateDtoUser setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CreateDtoUser setEmail(String email){
        this.email = email;
        return this;
    }

    public CreateDtoUser setRole(Roles role){
        this.role = role;
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

    public Roles getRole() {
        return role;
    }
}
