package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.databases.CustomerDatabase;
import com.switchfully.eurder.domain.elements.Customer;
import com.switchfully.eurder.domain.elements.User;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public UserService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    public User createUser(User user) {
        LOGGER.info("Creating a User");
        return userRepository.createUser(user);
    }

    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public boolean isAdmin(UUID userId) {
        return userRepository.isAdmin(userId);
    }
}
