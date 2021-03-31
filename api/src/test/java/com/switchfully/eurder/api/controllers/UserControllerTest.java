package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.users.CreateDtoUser;
import com.switchfully.eurder.api.mappers.ItemMapper;
import com.switchfully.eurder.api.mappers.UserMapper;
import com.switchfully.eurder.domain.databases.CustomerDatabase;
import com.switchfully.eurder.domain.databases.ItemDatabase;
import com.switchfully.eurder.domain.databases.UserDatabase;
import com.switchfully.eurder.domain.elements.Roles;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.ItemService;
import com.switchfully.eurder.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserControllerTest {

    private UserService userService;
    private UserMapper userMapper;
    private UserController userController;
    private CustomerService customerService;
    private ItemService itemService;
    private ItemMapper itemMapper;

    @BeforeEach
    public void init(){
        customerService = new CustomerService(new CustomerRepository(new CustomerDatabase()));
        userMapper = new UserMapper();
        itemMapper = new ItemMapper();
        userService = new UserService(new UserRepository(new UserDatabase()), new CustomerRepository(new CustomerDatabase()));
        itemService = new ItemService(new ItemRepository(new ItemDatabase()));
        userController = new UserController(userService, userMapper, customerService, itemService, itemMapper);
    }

    @Test
    void whenGettingAllTheUsers_theCorrectNumberIsReturned(){
        CreateDtoUser userTest = new CreateDtoUser().setFirstName("Joe").setLastName("Johnson").setEmail("joe@joe.io").setRole(Roles.ADMIN);
        userMapper.changeUserToDtoUser(userService.createUser(userMapper.changeDtoUserToUser(userTest)));
        Assertions.assertEquals(1, userController.getAllUsers().size());
    }

}