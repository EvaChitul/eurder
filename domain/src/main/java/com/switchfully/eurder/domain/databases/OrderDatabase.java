package com.switchfully.eurder.domain.databases;

import com.switchfully.eurder.domain.elements.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderDatabase {

    private final Map<UUID, List<Order>> orders = new HashMap<>();

    public Map<UUID, List<Order>> getAllOrders() {
        return orders;
    }

    public Order addOrderForCustomer(UUID customerID, Order order){
        if (orders.get(customerID) == null) { orders.put(customerID, new ArrayList<>());
        }
        orders.get(customerID).add(order);
        return orders.get(customerID).stream().filter(oneOrder -> oneOrder.getId() == order.getId()).findAny().get();
    }

    public Order getOneOrderForCustomer(UUID customerID, UUID orderID) {
        return orders.get(customerID).stream().filter(order -> order.getId() == orderID).findAny().get();
    }

    public List<Order> getAllOrdersForOneCustomer(UUID customerId){
        return orders.get(customerId);
    }
}
