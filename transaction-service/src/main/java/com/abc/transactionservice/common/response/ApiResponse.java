package com.abc.transactionservice.common.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ApiResponse {
    private String status;
    private Object data;
    private Object error;
}