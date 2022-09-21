package com.whatap.orderservice.presentation.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderUpdateRequest {

    @NotNull
    private Long productId;

    public OrderUpdateRequest() {
    }
}
