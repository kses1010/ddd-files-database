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
        return getOrderSummary(allOrders);
    }

    private List<OrderSummary> getOrderSummary(List<Order> orders) {
        List<OrderSummary> orderSummaries = new ArrayList<>();

        if (!orders.isEmpty()) {
            List<Long> productIds = orders.stream()
                .map(Order::getProductId)
                .collect(Collectors.toList());
            List<ProductDetail> productDetails = productService.getProducts(productIds);

            Map<Long, ProductDetail> productDetailMap = new HashMap<>();
            for (ProductDetail productDetail : productDetails) {
                productDetailMap.put(productDetail.getId(), productDetail);
            }

            for (Order order : orders) {
                Long productId = order.getProductId();
                orderSummaries.add(createOrderSummary(productDetailMap, order, productId));
            }
        }
        return orderSummaries;
    }

    private OrderSummary createOrderSummary(Map<Long, ProductDetail> productDetailMap, Order order, Long productId) {
        if (!productDetailMap.containsKey(productId)) {
            return OrderSummary.createNotExistProduct(order);
        }
        return OrderSummary.createExistProduct(order, productDetailMap.get(productId));
    }

    public List<OrderSummary> getOrders(OrderListQuery query) {
        List<Order> orders = orderRepository.findAll(query.getPageQuery());
        return getOrderSummary(orders);
    }
}
