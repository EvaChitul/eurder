package com.switchfully.eurder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    @Test
    void whenAddingACustomer_theSizeOfTheRepositoryIncreasesBy1(){
        Customer testCustomer = new Customer("Jeannie", "Nitro", "jeannie@nitro.io", "Java Street", "12345");
        CustomerRepository repository = new CustomerRepository(new CustomerDatabase());

        repository.createCustomer(testCustomer);
        Assertions.assertEquals(1, repository.getAllCustomers().size());
    }

}