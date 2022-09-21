package com.whatap.productservice.global.pagination;

import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class PageQueryDto {

    @Min(value = 1, message = "1보다 작은 페이지는 없습니다.")
    private int page = 1;

    @Range(min = 1, max = 255, message = "범위는 1에서 255까지만 제한됩니다.")
    private int limit = 10;

    public PageQueryDto() {
    }

    public PageQueryDto(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }
}
