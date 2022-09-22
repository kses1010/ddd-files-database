package com.whatap.productservice.global.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQuery {

    private int page;
    private int limit;

    public PageQuery() {
    }

    public PageQuery(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public int offset() {
        return page - 1;
    }
}
