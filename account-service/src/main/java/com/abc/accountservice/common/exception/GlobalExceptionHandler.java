package com.abc.accountservice.common.exception;

import com.abc.accountservice.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse> handleNoSuchElementException(NoSuchElementException noSuchElementException) {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setError(noSuchElementException.getMessage());


        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(apiResponse);
    }
}
