package com.whatap.productservice.presentation.request;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    public ProductCreateRequest() {
    }
}
