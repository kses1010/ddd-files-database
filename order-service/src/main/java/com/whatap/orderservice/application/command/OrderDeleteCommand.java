package com.whatap.orderservice.application.command;

import lombok.Getter;

@Getter
public class OrderDeleteCommand {

    private final Long id;

    public OrderDeleteCommand(Long id) {
        this.id = id;
    }
}
