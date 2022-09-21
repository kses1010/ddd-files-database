package com.whatap.orderservice.domain.order.exception;

import com.whatap.orderservice.global.error.ErrorCode;
import com.whatap.orderservice.global.error.exception.BusinessException;

public class OrderNotFoundException extends BusinessException {

    public OrderNotFoundException() {
        super(ErrorCode.ORDER_NOT_FOUND);
    }
}
