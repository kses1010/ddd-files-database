package com.whatap.orderservice.infra.product.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductByOrdersRequest {

    private List<Long> productIds;

    public ProductByOrdersRequest() {
    }

    public ProductByOrdersRequest(List<Long> productIds) {
        this.productIds = productIds;
    }
}
