package com.whatap.orderservice.application;

import com.whatap.orderservice.application.command.OrderDeleteCommand;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import com.whatap.orderservice.domain.order.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderDeleteAplService {

    private final OrderRepository orderRepository;

    @Transactional
    public void deleteOrder(OrderDeleteCommand command) {
        Order order = orderRepository.findById(command.getId()).orElseThrow(OrderNotFoundException::new);
        orderRepository.delete(order);
    }
}
