package com.whatap.orderservice.global.error;

import org.springframework.http.HttpStatus;

public interface ErrorObject {

    HttpStatus getHttpStatus();

    String getMessage();

    String name();
}
