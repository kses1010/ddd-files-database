package com.whatap.orderservice.application;

import com.whatap.orderservice.application.query.OrderDetailQuery;
import com.whatap.orderservice.application.query.OrderListQuery;
import com.whatap.orderservice.domain.order.Order;
import com.whatap.orderservice.domain.order.OrderRepository;
import com.whatap.orderservice.domain.order.exception.OrderNotFoundException;
import com.whatap.orderservice.domain.order.model.OrderDetail;
import com.whatap.orderservice.domain.order.model.OrderSummary;
import com.whatap.orderservice.domain.order.model.ProductDetail;
import com.whatap.orderservice.domain.order.service.ProductService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public List<OrderSummary> getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        List<OrderSummary> orderSummaries = new ArrayList<>();

        if (!allOrders.isEmpty()) {
            List<Long> productIds = allOrders.stream()
                .map(Order::getProductId)
                .collect(Collectors.toList());
            createOrderSummaries(allOrders, orderSummaries, productIds);
        }
        return orderSummaries;
    }

    private void createOrderSummaries(List<Order> orders, List<OrderSummary> orderSummaries, List<Long> productIds) {
        List<ProductDetail> productDetails = productService.getProducts(productIds);

        Map<Long, ProductDetail> productDetailMap = new HashMap<>();
        for (ProductDetail productDetail : productDetails) {
            productDetailMap.put(productDetail.getId(), productDetail);
        }

        for (Order order : orders) {
            Long productId = order.getProductId();
            if (!productDetailMap.containsKey(productId)) {
                orderSummaries.add(OrderSummary.createNotExistProduct(order));
            } else {
                orderSummaries.add(OrderSummary.createExistProduct(order, productDetailMap.get(productId)));
            }
        }
    }

    public List<Order> getOrders(OrderListQuery query) {
        return orderRepository.findAll(query.getPageQuery());
    }
}
