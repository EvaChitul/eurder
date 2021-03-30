package com.switchfully.eurder.api.dtos;

import com.switchfully.eurder.domain.elements.Roles;

import java.util.UUID;

public class DtoUser {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Roles role;

    public DtoUser setId(UUID id){
        this.id = id;
        return this;
    }

    public DtoUser setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public DtoUser setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public DtoUser setEmail(String email){
        this.email = email;
        return this;
    }

    public DtoUser setRole(Roles role){
        this.role = role;
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

    public Roles getRole() {
        return role;
    }
}
