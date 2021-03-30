package com.switchfully.eurder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void whenGivenNullFirstName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer(null, "Nitro", "jeannie@nitro.io", "Java Street", "12345"));
    }

    @Test
    void whenGivenEmptyFirstName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer(null, "Nitro", "jeannie@nitro.io", "Java Street", "12345"));
    }

    @Test
    void whenGivenNullLastName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", null, "jeannie@nitro.io", "Java Street", "12345"));
    }

    @Test
    void whenGivenEmptyLastName_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", null, "jeannie@nitro.io", "Java Street", "12345"));
    }

    @Test
    void whenGivenNullEmail_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", null, "Java Street", "12345"));
    }

    @Test
    void whenGivenWrongEmailFormat_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", "Java Street", "12345"));
    }

    @Test
    void whenGivenEmptyEmail_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "", "Java Street", "12345"));
    }

    @Test
    void whenGivenNullStreet_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", null, "12345"));
    }

    @Test
    void whenGivenEmptyStreet_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", "", "12345"));
    }

    @Test
    void whenGivenNullPhone_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", "", null));
    }

    @Test
    void whenGivenEmptyPhone_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", "", ""));
    }
}