package com.whatap.orderservice.application.query;

import lombok.Getter;

@Getter
public class OrderDetailQuery {

    private final Long id;

    public OrderDetailQuery(Long id) {
        this.id = id;
    }
}
