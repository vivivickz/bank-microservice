package com.abc.authenticationservice.common.exception;


import com.abc.authenticationservice.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse> handleNoSuchElementException(NoSuchElementException noSuchElementException) {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setError(noSuchElementException.getMessage());


        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(apiResponse);
    }
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ApiResponse> handleHttpClientErrorException() {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(null);
        apiResponse.setError("UNAUTHORIZED.TRY AGAIN");



        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(apiResponse);
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundException() {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(null);
        apiResponse.setError("User Not found");



        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(apiResponse);
    }
}
