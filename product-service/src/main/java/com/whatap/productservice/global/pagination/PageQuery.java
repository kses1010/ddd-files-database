package com.whatap.productservice.global.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQuery {

    private Long page;
    private Long limit;

    public PageQuery() {
    }

    public PageQuery(Long page, Long limit) {
        this.page = page;
        this.limit = limit;
    }

    public Long offest() {
        return (page - 1) * limit;
    }
}
