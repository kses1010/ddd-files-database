package com.whatap.orderservice.presentation.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateRequest {

    @NotNull
    private Long productId;

    public OrderCreateRequest() {
    }
}
