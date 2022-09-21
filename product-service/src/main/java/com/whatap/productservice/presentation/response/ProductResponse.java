package com.whatap.productservice.presentation.response;

import com.whatap.productservice.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductResponse {

    private final Long id;
    private final String name;

    public ProductResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
