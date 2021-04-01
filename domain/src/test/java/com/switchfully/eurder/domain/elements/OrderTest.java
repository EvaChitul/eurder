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
        List<ItemGroup> order = new ArrayList<>();
        order.add(new ItemGroup(UUID.randomUUID(), 2, 4));
        Assertions.assertEquals(1, order.size());
    }

    @Test
    void whenAddingAnInvalidItemGroupToAnOrder_thenThrowIllegalArgumentException(){
        List<ItemGroup> order = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> order.add(new ItemGroup(UUID.randomUUID(), -10, 4)));
    }

    @Test
    void whenAddingAnInvalidItemGroupToAnOrder_thenSizeOfOrderDoesNotIncrease(){
        List<ItemGroup> order = new ArrayList<>();
        try {
            order.add(new ItemGroup(UUID.randomUUID(), -10, 4));
        } catch (IllegalArgumentException exception){}

        Assertions.assertEquals(0, order.size());
    }

}