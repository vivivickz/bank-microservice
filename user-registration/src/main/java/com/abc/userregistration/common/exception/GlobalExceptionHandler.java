package com.abc.userregistration.common.exception;

import com.abc.userregistration.common.response.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse> handleNoSuchElementException(NoSuchElementException noSuchElementException) {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setError(noSuchElementException.getMessage());


        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(apiResponse);
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleDataIntegrityViolationException(
            DataIntegrityViolationException dataIntegrityViolationException) {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setError("the email id or phone number or Pan NUmber is already present");


        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(apiResponse);
    }
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ApiResponse> handleHttpClientErrorException() {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(null);
        apiResponse.setError("UNAUTHORIZED.TRY AGAIN");



        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(apiResponse);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                    HttpHeaders headers, HttpStatus status, WebRequest request){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setData(null);
        apiResponse.setError(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiResponse);

    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setData(null);
        apiResponse.setError("Please change the requested method ");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiResponse);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setData(null);
        apiResponse.setError("Specified path not present in the given server ");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiResponse);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatus status, WebRequest request) {


        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("error");
        apiResponse.setData(null);
        apiResponse.setError("Media type not accepted.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiResponse);
    }

}

