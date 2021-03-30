package com.switchfully.eurder.api.dtos;

import com.switchfully.eurder.domain.elements.Roles;

public class CreatedDtoUser {

    private String firstName;
    private String lastName;
    private String email;
    private Roles role;

    public CreatedDtoUser setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CreatedDtoUser setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CreatedDtoUser setEmail(String email){
        this.email = email;
        return this;
    }

    public CreatedDtoUser setRole(Roles role){
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
