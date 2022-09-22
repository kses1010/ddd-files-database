package com.whatap.orderservice.presentation.response;

import com.whatap.orderservice.domain.order.model.OrderSummary;
import lombok.Getter;

@Getter
public class OrderResponse {

    private final Long id;
    private final Long productId;
    private final String productName;

    public OrderResponse(Long id, Long productId, String productName) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
    }

    public OrderResponse(OrderSummary orderSummary) {
        this.id = orderSummary.getId();
        this.productId = orderSummary.getProductId();
        this.productName = orderSummary.getProductName();
    }
}
