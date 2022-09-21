package com.whatap.productservice.application.product.command;

import lombok.Getter;

@Getter
public class ProductCreateCommand {

    private final String name;
    private final String description;

    public ProductCreateCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
