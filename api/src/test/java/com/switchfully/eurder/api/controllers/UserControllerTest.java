package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.users.CreateDtoUser;
import com.switchfully.eurder.api.mappers.UserMapper;
import com.switchfully.eurder.domain.databases.CustomerDatabase;
import com.switchfully.eurder.domain.databases.UserDatabase;
import com.switchfully.eurder.domain.elements.Roles;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserControllerTest {

    private UserService userService;
    private UserMapper userMapper;
    private UserController userController;
    private CustomerService customerService;

    @BeforeEach
    public void init(){
        customerService = new CustomerService(new CustomerRepository(new CustomerDatabase()));
        userMapper = new UserMapper();
        userService = new UserService(new UserRepository(new UserDatabase()), new CustomerRepository(new CustomerDatabase()));
        userController = new UserController(userService, userMapper, customerService);
    }

    @Test
    void whenGettingAllTheUsers_theCorrectNumberIsReturned(){
        CreateDtoUser userTest = new CreateDtoUser().setFirstName("Joe").setLastName("Johnson").setEmail("joe@joe.io").setRole(Roles.ADMIN);
        userMapper.changeUserToDtoUser(userService.createUser(userMapper.changeDtoUserToUser(userTest)));
        Assertions.assertEquals(1, userController.getAllUsers().size());
    }

}