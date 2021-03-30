package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.databases.UserDatabase;
import com.switchfully.eurder.domain.elements.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserRepository {

    private final UserDatabase userDatabase;

    @Autowired
    public UserRepository(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public Collection<User> getAllUsers(){
        return userDatabase.getAllUsers();
    }

    public User createUser(User user) {
        return userDatabase.createUser(user);
    }
}
