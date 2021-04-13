package com.switchfully.eurder.api.controllers;

import com.switchfully.eurder.api.dtos.orders.CreateDtoOrder;
import com.switchfully.eurder.api.dtos.orders.DtoOrder;
import com.switchfully.eurder.api.mappers.OrderMapper;
import com.switchfully.eurder.domain.elements.Order;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.ItemService;
import com.switchfully.eurder.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderMapper orderMapper;
    private final OrderService orderService;


    @Autowired
    public OrderController(OrderMapper orderMapper, OrderService orderService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoOrder addOrder(@RequestParam UUID customerID, @RequestBody CreateDtoOrder orderToAdd){
        LOGGER.info("Adding an order");
        return orderMapper.changeOrderToDtoOrder(orderService.addOrderForCustomer(customerID, orderMapper.changeDtoOrdertoOrder(orderToAdd)));
    }
}
