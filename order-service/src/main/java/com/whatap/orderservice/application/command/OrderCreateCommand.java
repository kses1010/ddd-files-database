package com.whatap.orderservice.application.command;

import lombok.Getter;

@Getter
public class OrderCreateCommand {

    private final Long productId;

    public OrderCreateCommand(Long productId) {
        this.productId = productId;
    }
}
