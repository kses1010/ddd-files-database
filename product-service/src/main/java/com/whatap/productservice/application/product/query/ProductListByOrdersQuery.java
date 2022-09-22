package com.whatap.productservice.application.product.query;

import java.util.List;
import lombok.Getter;

@Getter
public class ProductListByOrdersQuery {

    private final List<Long> ids;

    public ProductListByOrdersQuery(List<Long> ids) {
        this.ids = ids;
    }
}
