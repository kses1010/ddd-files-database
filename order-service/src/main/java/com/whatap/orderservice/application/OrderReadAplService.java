package com.whatap.orderservice.application;

import com.whatap.orderservice.application.query.OrderDetailQuery;
import com.whatap.orderservice.application.query.OrderListQuery;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import com.whatap.orderservice.domain.order.exception.OrderNotFoundException;
import com.whatap.orderservice.domain.order.model.OrderDetail;
import com.whatap.orderservice.domain.order.model.ProductDetail;
import com.whatap.orderservice.domain.order.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderReadAplService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderDetail getOrderDetail(OrderDetailQuery query) {
        Order order = orderRepository.findById(query.getId()).orElseThrow(OrderNotFoundException::new);
        ProductDetail productDetail = productService.getProductDetail(order.getProductId());
        return OrderDetail.of(order, productDetail);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrders(OrderListQuery query) {
        return orderRepository.findAll(query.getPageQuery());
    }
}
