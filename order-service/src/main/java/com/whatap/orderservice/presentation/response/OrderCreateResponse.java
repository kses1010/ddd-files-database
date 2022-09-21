package com.whatap.orderservice.presentation.response;

import com.whatap.orderservice.domain.order.Order;
import lombok.Getter;

@Getter
public class OrderCreateResponse {

    private final Long id;
    private final Long productId;

    public OrderCreateResponse(Long id, Long productId) {
        this.id = id;
        this.productId = productId;
    }

    public OrderCreateResponse(Order order) {
        this.id = order.getId();
        this.productId = order.getProductId();
    }
}
