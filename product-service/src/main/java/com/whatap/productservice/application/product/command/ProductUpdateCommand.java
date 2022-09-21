package com.whatap.productservice.application.product.command;

import lombok.Getter;

@Getter
public class ProductUpdateCommand {

    private final Long id;
    private final String name;
    private final String description;

    public ProductUpdateCommand(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
