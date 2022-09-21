package com.whatap.orderservice.application;

import com.whatap.orderservice.application.command.OrderCreateCommand;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import com.whatap.orderservice.domain.order.model.ProductDetail;
import com.whatap.orderservice.domain.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderCreateAplService {

    private final ProductService productService;
    private final OrderRepository orderRepository;

    @Transactional
    public Order createOrder(OrderCreateCommand command) {
        ProductDetail productDetail = productService.getProductDetail(command.getProductId());
        Order order = Order.createOrder(productDetail.getId());
        return orderRepository.save(order);
    }
}
