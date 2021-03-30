package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.elements.Customer;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomerService {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
        LOGGER.info("Creating customer");
        return customerRepository.createCustomer(customer);
    }

    public Collection<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

}
