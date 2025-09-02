package com.noelnp.sportsbooklite.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;

public class ApiExceptionHandler {

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
