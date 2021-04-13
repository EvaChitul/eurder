package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.databases.OrderDatabase;
import com.switchfully.eurder.domain.elements.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderRepository {

    private final OrderDatabase orderDatabase;

    @Autowired
    public OrderRepository(OrderDatabase orderDatabase) {
        this.orderDatabase = orderDatabase;
    }

    public Map<UUID, List<Order>> getAllOrders(){ return orderDatabase.getAllOrders();}

    public Order addOrderForCustomer(UUID customerId, Order order){
        return orderDatabase.addOrderForCustomer(customerId, order);
    }

    public Order getOneOrderForCustomer(UUID customerID, UUID orderID) {
        return orderDatabase.getOneOrderForCustomer(customerID, orderID);
    }

    public List<Order> getAllOrdersForCustomer(UUID customerID){
        return orderDatabase.getAllOrdersForOneCustomer(customerID);
    }
}
