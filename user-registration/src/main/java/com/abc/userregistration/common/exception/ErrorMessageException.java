package com.abc.userregistration.common.response.exception;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private  String status;
    private  String data;
    private String error;




}
