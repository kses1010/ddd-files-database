package com.whatap.productservice.global.error;

import com.whatap.productservice.global.error.exception.BusinessException;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public ErrorResponse(BusinessException e) {
        this.message = e.getMessage();
    }
}
