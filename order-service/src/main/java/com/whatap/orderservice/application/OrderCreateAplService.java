package com.whatap.orderservice.application;

import com.whatap.orderservice.application.command.OrderCreateCommand;
import com.whatap.orderservice.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderCreateAplService {

    @Transactional
    public Order createOrder(OrderCreateCommand command) {

    }
}
