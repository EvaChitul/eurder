package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.elements.User;
import com.switchfully.eurder.domain.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        LOGGER.info("Creating a User");
        return userRepository.createUser(user);
    }

    public Collection<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
}
