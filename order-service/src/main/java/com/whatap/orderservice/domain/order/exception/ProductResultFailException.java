package com.whatap.orderservice.domain.order.exception;

import com.whatap.orderservice.global.error.ErrorCode;
import com.whatap.orderservice.global.error.exception.BusinessException;

public class ProductResultFailException extends BusinessException {

    public ProductResultFailException() {
        super(ErrorCode.PRODUCT_RESULT_FAIL);
    }
}
