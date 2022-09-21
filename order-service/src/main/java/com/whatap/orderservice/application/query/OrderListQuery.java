package com.whatap.orderservice.application.query;

import com.whatap.orderservice.global.pagination.PageQuery;
import lombok.Getter;

@Getter
public class OrderListQuery {

    private final PageQuery pageQuery;

    public OrderListQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }
}
