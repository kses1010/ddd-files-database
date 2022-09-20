package com.whatap.orderservice.global.error.exception;

import com.whatap.orderservice.global.error.ErrorObject;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final transient ErrorObject errorObject;

    public BusinessException(ErrorObject errorObject) {
        super(errorObject.getMessage());
        this.errorObject = errorObject;
    }
}
