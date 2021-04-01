package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.elements.Order;
import com.switchfully.eurder.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Map<UUID, List<Order>> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    public List<Order> addOrderForCustomer(UUID customerID, Order order){
        return orderRepository.addOrderForCustomer(customerID, order);
    }

    public List<Order> getAllOrdersForCustomer(UUID customerID){
        return orderRepository.getAllOrdersForCustomer(customerID);
    }
}
