package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerMapper.class);

    public DtoCustomer changeCustomerToDtoCustomer(Customer customer){
        LOGGER.info("Returning a DtoCustomer based on Customer with id " + customer.getId());
        return new DtoCustomer()
                .setId(customer.getId())
                .setAddress(customer.getAddress())
                .setEmail(customer.getEmail())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setPhone(customer.getPhone());
    }

    public Customer changeDtoConsumerToCustomer(CreateDtoCustomer dtoCustomer){
        LOGGER.info("Returning a Customer based on a DtoCustomer");
        return new Customer(dtoCustomer.getFirstName(), dtoCustomer.getLastName(), dtoCustomer.getEmail(), dtoCustomer.getAddress(), dtoCustomer.getPhone());
    }


}
