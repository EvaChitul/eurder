package com.switchfully.eurder.domain.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void whenAddingAnItemGroupToAnOrder_thenSizeOfOrderIncreasesBy1(){
        Order order = new Order();
        order.getOrderItems().add(new ItemGroup(UUID.randomUUID(), 2, 4));
        Assertions.assertEquals(1, order.getOrderItems().size());
    }

    @Test
    void whenAddingAnInvalidItemGroupToAnOrder_thenThrowIllegalArgumentException(){
        Order order = new Order();
        Assertions.assertThrows(IllegalArgumentException.class, () ->  order.getOrderItems().add(new ItemGroup(UUID.randomUUID(), -10, 4)));
    }

    @Test
    void whenAddingAnInvalidItemGroupToAnOrder_thenSizeOfOrderDoesNotIncrease(){
        Order order = new Order();
        try {
            order.getOrderItems().add(new ItemGroup(UUID.randomUUID(), -10, 4));
        } catch (IllegalArgumentException exception){}

        Assertions.assertEquals(0, order.getOrderItems().size());
    }

}