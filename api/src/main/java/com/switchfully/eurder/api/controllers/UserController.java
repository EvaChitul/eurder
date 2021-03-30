package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.CreatedDtoUser;
import com.switchfully.eurder.api.dtos.DtoCustomer;
import com.switchfully.eurder.api.dtos.DtoUser;
import com.switchfully.eurder.api.mappers.UserMapper;
import com.switchfully.eurder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoUser createUser(@RequestBody CreatedDtoUser createdDtoUser){
        LOGGER.info("Creating a user");
        return userMapper.changeUserToDtoUser(userService.createUser(userMapper.changeDtoUserToUser(createdDtoUser)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DtoUser> getAllUsers(){
        LOGGER.info("Getting all the users");
        return userMapper.changeCollectionOfUsersToListOfDtoUsers(userService.getAllUsers());
    }
}
