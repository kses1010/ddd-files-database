package com.whatap.orderservice.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode implements ErrorObject {

    // common
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류입니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "올바르지 않은 입력 값입니다."),
    INVALID_POST(HttpStatus.BAD_REQUEST, "입력을 하지 않았거나 잘못된 형식입니다."),
    MISSING_REQUEST_PARAMETER_VALUE(HttpStatus.BAD_REQUEST, "올바르지 않은 요청입니다. 요청 정보를 확인 후 다시 시도해주세요."),
    INVALID_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "올바르지 않은 입력 값입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "서비스 오류입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
