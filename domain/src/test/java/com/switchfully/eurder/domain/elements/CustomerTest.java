package com.switchfully.eurder.domain.elements;

import com.switchfully.eurder.domain.elements.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void whenGivenNullAddress_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", null, "12345"));
    }

    @Test
    void whenGivenEmptyAddress_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", "", "12345"));
    }

    @Test
    void whenGivenNullPhone_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", "Java Street", null));
    }

    @Test
    void whenGivenEmptyPhone_thenThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Customer("Jeannie", "Nitro", "jeannienitro.io", "Java Street", ""));
    }

}