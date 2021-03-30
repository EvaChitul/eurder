package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.databases.CustomerDatabase;
import com.switchfully.eurder.domain.elements.Customer;
import com.switchfully.eurder.domain.elements.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class CustomerRepository {

    private final CustomerDatabase database;

    @Autowired
    public CustomerRepository(CustomerDatabase database) {
        this.database = database;
    }

    public Collection<Customer> getAllCustomers(){
        return database.getAllCustomers();
    }

    public Customer createCustomer(Customer customer){
        return database.createCustomer(customer);
    }

}
