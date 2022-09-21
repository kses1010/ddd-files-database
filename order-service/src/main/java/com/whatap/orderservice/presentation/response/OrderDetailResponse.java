package com.whatap.orderservice.presentation.response;

import com.whatap.orderservice.domain.order.Order;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class OrderDetailResponse {

    private final Long id;
    private final Long productId;
    private final LocalDateTime createdAt;

    public OrderDetailResponse(Long id, Long productId, LocalDateTime createdAt) {
        this.id = id;
        this.productId = productId;
        this.createdAt = createdAt;
    }

    public OrderDetailResponse(Order order) {
        this.id = order.getId();
        this.productId = order.getProductId();
        this.createdAt = order.getCreatedAt();
    }
}
