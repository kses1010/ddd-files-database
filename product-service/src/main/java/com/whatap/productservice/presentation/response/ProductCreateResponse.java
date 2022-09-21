package com.whatap.productservice.presentation.response;

import com.whatap.productservice.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductCreateResponse {

    private final Long id;
    private final String name;
    private final String description;

    public ProductCreateResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProductCreateResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }
}
