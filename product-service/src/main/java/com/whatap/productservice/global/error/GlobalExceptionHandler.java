package com.whatap.productservice.global.error;

import com.whatap.productservice.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * (@RequestBody) Validation 유효성 예외시 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.INVALID_PARAMETER),
            ErrorCode.INVALID_PARAMETER.getHttpStatus());
    }

    /**
     * Request Parameter에 필요한 값을 넣지 않은 경우 예외 발생
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(
        MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException", e);

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.MISSING_REQUEST_PARAMETER_VALUE),
            ErrorCode.MISSING_REQUEST_PARAMETER_VALUE.getHttpStatus());
    }

    /**
     * @ModelAttribute 으로 binding error 발생시 BindException 발생 또는 Validation 하기 전 Bean Property가 Bind에 실패해도 발생
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("handleBindException", e);

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.INVALID_REQUEST_PARAMETER),
            ErrorCode.INVALID_REQUEST_PARAMETER.getHttpStatus());
    }

    /**
     * 컨트롤러에서 애노테이션 @RequestParam 타입 맞지 않을 때 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
        MethodArgumentTypeMismatchException e) {
        log.error("handleMethodArgumentTypeMismatchException", e);

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.INVALID_REQUEST_PARAMETER),
            ErrorCode.INVALID_REQUEST_PARAMETER.getHttpStatus());
    }

    /**
     * POST 메소드의 RequestBody 형식이 잘못 되거나 비어있을 경우 발생
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
        HttpMessageNotReadableException e) {
        log.error("handleHttpMessageNotReadableException", e);

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.INVALID_POST), ErrorCode.INVALID_POST.getHttpStatus());
    }

    /**
     * 지원하지 않는 HTTP Method를 요청할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
        HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED),
            ErrorCode.METHOD_NOT_ALLOWED.getHttpStatus());
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.error("handleBusinessException", e);

        return new ResponseEntity<>(new ErrorResponse(e), e.getErrorObject().getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException", e);

        return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR),
            ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus());
    }
}
