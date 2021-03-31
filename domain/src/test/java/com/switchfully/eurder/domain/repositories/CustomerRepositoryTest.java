package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.databases.CustomerDatabase;
import com.switchfully.eurder.domain.elements.Customer;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerRepositoryTest {

    @Test
    void whenAddingACustomer_theSizeOfTheRepositoryIncreasesBy1(){
        Customer testCustomer = new Customer("Jeannie", "Nitro", "jeannie@nitro.io", "Java Street", "12345");
        CustomerRepository repository = new CustomerRepository(new CustomerDatabase());

        repository.createCustomer(testCustomer);
        Assertions.assertEquals(1, repository.getAllCustomers().size());
    }

}