package com.whatap.orderservice.domain.order.model;

import lombok.Getter;

@Getter
public class ProductDetail {

    private final Long id;
    private final String name;
    private final String description;

    public ProductDetail(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
