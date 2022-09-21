package com.whatap.productservice.presentation.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateRequest {

    private String name;
    private String description;

    public ProductCreateRequest() {
    }
}
