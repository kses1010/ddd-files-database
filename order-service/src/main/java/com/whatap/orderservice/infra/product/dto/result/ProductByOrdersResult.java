package com.whatap.orderservice.infra.product.dto.result;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductByOrdersResult {

    private List<ProductResult> productResults = new ArrayList<>();

    public ProductByOrdersResult() {
    }

    public ProductByOrdersResult(List<ProductResult> productResults) {
        this.productResults = productResults;
    }
}
