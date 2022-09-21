package com.whatap.orderservice.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Order {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Order() {
    }

    @Builder
    private Order(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
