package com.whatap.orderservice.domain.order;

import com.whatap.orderservice.infra.order.OrderEntity;
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
    public Order(Long id, Long productId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productId = productId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Order createOrder(Long productId) {
        return Order.builder()
            .productId(productId)
            .createdAt(LocalDateTime.now())
            .build();
    }

    public OrderEntity toEntity() {
        return OrderEntity.builder()
            .id(id)
            .productId(productId)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .build();
    }

    public void changeProduct(Long productId) {
        this.productId = productId;
    }
}
