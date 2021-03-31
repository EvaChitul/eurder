package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.users.CreateDtoUser;
import com.switchfully.eurder.api.dtos.users.DtoUser;
import com.switchfully.eurder.api.mappers.UserMapper;
import com.switchfully.eurder.domain.elements.Customer;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final UserMapper userMapper;
    private final CustomerService customerService;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper, CustomerService customerService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoUser createUser(@RequestBody CreateDtoUser createdDtoUser){
        LOGGER.info("Creating a user");
        return userMapper.changeUserToDtoUser(userService.createUser(userMapper.changeDtoUserToUser(createdDtoUser)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DtoUser> getAllUsers(){
        LOGGER.info("Getting all the users");
        return userMapper.changeCollectionOfUsersToListOfDtoUsers(userService.getAllUsers());
    }

    @GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Customer> getAllCustomers(@RequestParam UUID userId){
        if(!userService.isAdmin(userId))
            throw new IllegalStateException("You do not have permission to access all customers. Permission reserved for ADMIN");
        LOGGER.info("User(admin) with ID " + userId +" requesting an overview of all the customers ");
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Customer getOneCustomerById(@PathVariable("id") String id, @RequestParam UUID userId){
        if(!userService.isAdmin(userId))
            throw new IllegalStateException("You do not have permission to access the customer. Permission reserved for ADMIN");
        LOGGER.info("User(admin) with ID " + userId +" requesting an overview of customer with ID " + id);
        return customerService.getOneCustomer(UUID.fromString(id));
    }
}
