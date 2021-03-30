package com.switchfully.eurder.domain.databases;

import com.switchfully.eurder.domain.elements.Customer;
import com.switchfully.eurder.domain.elements.User;
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
