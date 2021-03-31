package com.switchfully.eurder.domain.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void whenGivenNullName_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item(null, "this is an item", 12.9, 2));
    }

    @Test
    void whenGivenEmptyName_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("", "this is an item", 12.9, 2));
    }

    @Test
    void whenGivenNSpaceAsName_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item(" ", "this is an item", 12.9, 2));
    }

    @Test
    void whenGivenNullDescription_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("item", null, 12.9, 2));
    }

    @Test
    void whenGivenEmptyDescription_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("item", "", 12.9, 2));
    }

    @Test
    void whenGivenNSpaceAsDescription_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("item", " ", 12.9, 2));
    }

    @Test
    void whenGivenNegativePrice_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("item", "this is an item", -10, 2));
    }

    @Test
    void whenGivenZeroAsPrice_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("item", " ", 0, 2));
    }

    @Test
    void whenGivenNegativeNumberAsStock_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("item", " ", 10, -5));
    }

}