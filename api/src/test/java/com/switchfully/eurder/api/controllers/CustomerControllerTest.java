package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.controllers.CustomerController;
import com.switchfully.eurder.api.dtos.CreateDtoCustomer;
import com.switchfully.eurder.api.mappers.CustomerMapper;
import com.switchfully.eurder.domain.databases.CustomerDatabase;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import com.switchfully.eurder.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerControllerTest {

    //COMMENT OUT BELOW ONCE FINALISED

    private CustomerController customerController;
    private CustomerMapper customerMapper;
    private CustomerService customerService;

    @BeforeEach
    public void init(){
        customerService = new CustomerService(new CustomerRepository(new CustomerDatabase()));
        customerMapper = new CustomerMapper();
        customerController = new CustomerController(customerService, customerMapper);
    }

    @Test
    void whenGettingAllCustomers_theCorrectNumberIsReturned(){
        CreateDtoCustomer customerTest = new CreateDtoCustomer().setFirstName("Jeannie").setLastName("Nitro").setEmail("jeannie@nitro.io").setAddress("Here").setPhone("12345");
        customerMapper.changeCustomerToDtoCustomer(customerService.createCustomer(customerMapper.changeDtoConsumerToCustomer(customerTest)));
        Assertions.assertEquals(1, customerController.getAllCustomers().size());

    }



}