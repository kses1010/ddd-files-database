package com.whatap.orderservice.presentation.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateRequest {

    private Long productId;

    public OrderCreateRequest() {
    }
}
