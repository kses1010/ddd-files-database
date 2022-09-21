package com.whatap.productservice.application.product.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateCommand {

    private String name;
    private String description;

    public ProductCreateCommand() {
    }

    public ProductCreateCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
