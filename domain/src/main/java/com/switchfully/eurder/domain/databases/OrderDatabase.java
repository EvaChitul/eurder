package com.switchfully.eurder.domain.databases;

import com.switchfully.eurder.domain.elements.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderDatabase {

    private final Map<UUID, List<Order>> orders = new HashMap<>();

    public Map<UUID, List<Order>> getAllOrders() {
        return orders;
    }

    public List<Order> getAllOrdersForOneCustomer(UUID customerId){
        return orders.get(customerId);
    }

    public List<Order> addOrderForCustomer(UUID customerID, Order order){
        orders.get(customerID).add(order);
        return orders.get(customerID);
    }
}
