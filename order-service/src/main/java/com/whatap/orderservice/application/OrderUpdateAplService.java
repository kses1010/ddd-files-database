package com.whatap.orderservice.application;

import com.whatap.orderservice.application.command.OrderUpdateCommand;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import com.whatap.orderservice.domain.order.exception.OrderNotFoundException;
import com.whatap.orderservice.domain.order.model.OrderSummary;
import com.whatap.orderservice.domain.order.model.ProductDetail;
import com.whatap.orderservice.domain.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderUpdateAplService {

    private final ProductService productService;
    private final OrderRepository orderRepository;

    @Transactional
    public OrderSummary updateOrder(OrderUpdateCommand command) {
        Order order = orderRepository.findById(command.getId()).orElseThrow(OrderNotFoundException::new);
        ProductDetail productDetail = productService.getProductDetail(command.getProductId());

        order.changeProduct(productDetail.getId());
        orderRepository.save(order);
        return OrderSummary.createExistProduct(order, productDetail);
    }
}
