package com.whatap.productservice.global.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQuery {

    private Integer page;
    private Integer limit;

    public PageQuery() {
    }

    public PageQuery(Integer page, Integer limit) {
        this.page = page == null ? 1 : page;
        this.limit = limit == null ? 10 : limit;
    }

    public int offset() {
        return (page - 1) * limit;
    }
}
