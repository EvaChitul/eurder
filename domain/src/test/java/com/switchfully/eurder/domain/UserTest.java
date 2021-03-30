package com.switchfully.eurder.domain;

import com.switchfully.eurder.domain.elements.Roles;
import com.switchfully.eurder.domain.elements.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void whenGivenNullFirstName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, "Nitro", "jeannie@nitro.io", "Java Street", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenEmptyFirstName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, "Nitro", "jeannie@nitro.io", "Java Street", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenNullLastName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", null, "jeannie@nitro.io", "Java Street", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenEmptyLastName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", null, "jeannie@nitro.io", "Java Street", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenNullEmail_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", null, "Java Street", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenWrongEmailFormat_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", "jeannienitro.io", "Java Street", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenEmptyEmail_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", "", "Java Street", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenNullAddress_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", "jeannienitro.io", null, "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenEmptyAddress_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", "jeannienitro.io", " ", "12345", Roles.ADMIN));
    }

    @Test
    void whenGivenNullPhone_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", "jeannienitro.io", "Java Street", null, Roles.ADMIN));
    }

    @Test
    void whenGivenEmptyPhone_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", "jeannienitro.io", "Java Street", "", Roles.ADMIN));
    }

    @Test
    void whenGivenNullRolethenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Jeannie", "Nitro", "jeannienitro.io", "Java Street", "12345", null));
    }

}