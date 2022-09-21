package com.whatap.productservice.application.product.query;

import lombok.Getter;

@Getter
public class ProductDetailQuery {

    private final Long id;

    public ProductDetailQuery(Long id) {
        this.id = id;
    }
}
