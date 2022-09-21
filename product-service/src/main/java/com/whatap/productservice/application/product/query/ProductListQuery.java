package com.whatap.productservice.application.product.query;

import com.whatap.productservice.global.pagination.PageQuery;
import lombok.Getter;

@Getter
public class ProductListQuery {

    private final PageQuery pageQuery;

    public ProductListQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }
}
