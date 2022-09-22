package com.whatap.orderservice.domain.order.model;

import com.whatap.orderservice.domain.order.Order;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class OrderDetail {

    private final Long id;
    private final Long productId;
    private final String productName;
    private final String productDescription;
    private final LocalDateTime orderedTime;

    public OrderDetail(Long id, Long productId, String productName, String productDescription,
        LocalDateTime orderedTime) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.orderedTime = orderedTime;
    }

    public static OrderDetail of(Order order, ProductDetail productDetail) {
        return new OrderDetail(
            order.getId(),
            productDetail.getId(),
            productDetail.getName(),
            productDetail.getDescription(),
            order.getCreatedAt()
        );
    }
}
