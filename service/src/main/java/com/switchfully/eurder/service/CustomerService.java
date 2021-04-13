package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.elements.Customer;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.createCustomer(customer);
    }

    public Collection<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    public Customer getOneCustomer(UUID id) { return customerRepository.getOneCustomer(id);};

    public boolean isCustomer(UUID customerID) {
        return customerRepository.isCustomer(customerID);
    }

}
