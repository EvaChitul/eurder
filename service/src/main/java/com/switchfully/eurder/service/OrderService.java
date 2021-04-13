package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.elements.Order;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ItemService itemService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerService customerService, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.itemService = itemService;
    }

    public Map<UUID, List<Order>> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    public Order addOrderForCustomer(UUID customerID, Order order){
        if(!isCustomer(customerID)) throw new IllegalArgumentException("Customer is not registered in the system. Cannot place order");
        return orderRepository.addOrderForCustomer(customerID, order);
    }

    public List<Order> getAllOrdersForCustomer(UUID customerID){
        return orderRepository.getAllOrdersForCustomer(customerID);
    }

    public Order getOrderForCustomer(UUID customerID, UUID orderID){
        return orderRepository.getOneOrderForCustomer(customerID, orderID);
    }

    private boolean isCustomer(UUID customerID) {
        return customerService.isCustomer(customerID);
    }
}
