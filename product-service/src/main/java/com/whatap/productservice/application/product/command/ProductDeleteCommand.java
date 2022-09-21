package com.whatap.productservice.application.product.command;

import lombok.Getter;

@Getter
public class ProductDeleteCommand {

    private final Long id;

    public ProductDeleteCommand(Long id) {
        this.id = id;
    }
}
