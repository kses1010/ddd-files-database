package com.whatap.productservice.presentation.response;

import com.whatap.productservice.domain.product.Product;
import java.util.List;
import lombok.Getter;

@Getter
public class ProductByOrdersResponse {

    private final List<Product> productResults;

    public ProductByOrdersResponse(List<Product> productResults) {
        this.productResults = productResults;
    }
}
