package com.noelnp.sportsbooklite.shared.web;

import com.noelnp.sportsbooklite.exception.ApiException;
import com.noelnp.sportsbooklite.exception.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;


        ApiException apiException = new ApiException(
                exception.getMessage(),
                exception,
                httpStatus,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, httpStatus);

    }
}
