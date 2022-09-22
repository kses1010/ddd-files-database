package com.whatap.orderservice.domain.order.model;

import com.whatap.orderservice.domain.order.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderSummary {

    private final Long id;
    private final Long productId;
    private final String productName;

    @Builder
    public OrderSummary(Long id, Long productId, String productName) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
    }

    public static OrderSummary createNotExistProduct(Order order) {
        return OrderSummary.builder()
            .id(order.getId())
            .productId(order.getProductId())
            .build();
    }

    public static OrderSummary createExistProduct(Order order, ProductDetail productDetail) {
        return OrderSummary.builder()
            .id(order.getId())
            .productId(productDetail.getId())
            .productName(productDetail.getName())
            .build();
    }
}
