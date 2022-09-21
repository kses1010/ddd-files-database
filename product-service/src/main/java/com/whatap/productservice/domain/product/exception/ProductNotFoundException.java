package com.whatap.productservice.domain.product.exception;

import com.whatap.productservice.global.error.ErrorCode;
import com.whatap.productservice.global.error.exception.BusinessException;

public class ProductNotFoundException extends BusinessException {

    public ProductNotFoundException() {
        super(ErrorCode.PRODUCT_NOT_FOUND);
    }
}
