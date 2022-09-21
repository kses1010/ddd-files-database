package com.whatap.orderservice.domain.order.exception;

import com.whatap.orderservice.global.error.ErrorCode;
import com.whatap.orderservice.global.error.exception.BusinessException;

public class ProductResultNotFoundException extends BusinessException {

    public ProductResultNotFoundException() {
        super(ErrorCode.PRODUCT_NOT_FOUND);
    }
}
