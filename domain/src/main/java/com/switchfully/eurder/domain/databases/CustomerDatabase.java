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
        if(customerAlreadyInDatabase(customer)) throw new IllegalArgumentException("Customer with email " + customer.getEmail() + " already registered");
        customers.put(customer.getId(), customer);
        return customers.get(customer.getId());
    }

    private boolean customerAlreadyInDatabase(Customer customer) {
        return customers.containsValue(customer);
    }

    public Customer getOneCustomer(UUID id) {
        if (!customers.containsKey(id)) throw new IllegalArgumentException("Cannot retrieve customer, invalid ID provided");
        return customers.get(id);
    }
}
