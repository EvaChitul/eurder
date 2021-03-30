package com.switchfully.eurder.domain;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerDatabase {

    private final Map<UUID, Customer> customers = new HashMap<>();

    public Collection<Customer> getAllCustomers(){
        return customers.values();};

    public Customer createCustomer(Customer customer){
        customers.put(customer.getId(), customer);
        return customers.get(customer.getId());
    }
}
