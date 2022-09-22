package com.whatap.orderservice.presentation.response;

import com.whatap.orderservice.domain.order.model.OrderDetail;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class OrderDetailResponse {

    private final Long id;
    private final Long productId;
    private final String productName;
    private final String productDescription;
    private final LocalDateTime orderedTime;

    public OrderDetailResponse(Long id, Long productId, String productName, String productDescription,
        LocalDateTime orderedTime) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.orderedTime = orderedTime;
    }


    public OrderDetailResponse(OrderDetail orderDetail) {
        this.id = orderDetail.getId();
        this.productId = orderDetail.getProductId();
        this.productName = orderDetail.getProductName();
        this.productDescription = orderDetail.getProductDescription();
        this.orderedTime = orderDetail.getOrderedTime();
    }
}
