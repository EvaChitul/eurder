package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.databases.UserDatabase;
import com.switchfully.eurder.domain.elements.Roles;
import com.switchfully.eurder.domain.elements.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void whenCreatingAUser_theSizeOfTheRepositoryIncreasesBy1(){
        User user = new User("firstname", "lastname", "email@email.com", Roles.ADMIN);
        UserRepository repository = new UserRepository(new UserDatabase());
        repository.createUser(user);
        Assertions.assertEquals(1, repository.getAllUsers().size());
    }

    @Test
    void whenCreatingAUserWhoseEmailIsAlreadyRegistered_thenThrowIllegalArgumentException(){
        User user = new User("firstname", "lastname", "email@email.com", Roles.ADMIN);
        User secondUser = new User("second", "second name", "email@email.com", Roles.OTHER);
        UserRepository repository = new UserRepository(new UserDatabase());
        repository.createUser(user);
        Assertions.assertThrows(IllegalArgumentException.class, () -> repository.createUser(secondUser));
    }

    @Test
    void whenCreatingAUserWhoseEmailIsAlreadyRegistered_thenSizeOfRepositoryDoesNotIncrease(){
        User user = new User("firstname", "lastname", "email@email.com", Roles.ADMIN);
        User secondUser = new User("second", "second name", "email@email.com", Roles.OTHER);
        UserRepository repository = new UserRepository(new UserDatabase());
        repository.createUser(user);
        try {
            repository.createUser(secondUser);
        } catch (IllegalArgumentException exception) {}
        Assertions.assertEquals(1, repository.getAllUsers().size());
    }

}