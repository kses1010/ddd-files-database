package com.whatap.orderservice.application;

import com.whatap.orderservice.application.query.OrderDetailQuery;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import com.whatap.orderservice.domain.order.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderReadAplService {

    private final OrderRepository orderRepository;

    public Order getOrderDetail(OrderDetailQuery query) {
        return orderRepository.findById(query.getId()).orElseThrow(OrderNotFoundException::new);
    }
}