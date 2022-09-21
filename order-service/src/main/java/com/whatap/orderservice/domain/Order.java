package com.whatap.orderservice.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Order {

    private Long id;
    private Long productId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Order() {
    }

    @Builder
    private Order(Long id, Long productId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productId = productId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
