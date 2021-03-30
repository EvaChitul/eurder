package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoCustomer createCustomer(@RequestBody CreateDtoCustomer customer){
        LOGGER.info("Creating a customer");
        return customerMapper.changeCustomerToDtoCustomer(customerService.createCustomer(customerMapper.changeDtoConsumerToCustomer(customer)));

    }
}
