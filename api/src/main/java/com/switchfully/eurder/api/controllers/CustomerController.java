package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.CreateDtoCustomer;
import com.switchfully.eurder.api.mappers.CustomerMapper;
import com.switchfully.eurder.api.dtos.DtoCustomer;
import com.switchfully.eurder.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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

    //COMMENT OUT BELOW ONCE FINALISED

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DtoCustomer> getAllCustomers(){
        LOGGER.info("Getting all the customers");
        return customerMapper.changeCollectionOfCustomersToListOfDtoCustomers(customerService.getAllCustomers());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoCustomer getCustomerByID(@PathVariable("id") String id){
        LOGGER.info("Getting one customer with UUID " + id);
        return customerMapper.changeCustomerToDtoCustomer(customerService.getOneCustomer(UUID.fromString(id)));
    }
}
