package com.whatap.orderservice.application.command;

import lombok.Getter;

@Getter
public class OrderUpdateCommand {

    private final Long id;
    private final Long productId;

    public OrderUpdateCommand(Long id, Long productId) {
        this.id = id;
        this.productId = productId;
    }
}
