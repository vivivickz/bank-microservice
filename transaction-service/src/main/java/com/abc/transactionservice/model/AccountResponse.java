package com.abc.transactionservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AccountResponse {

    private  String status;
    private Object error;
    private ResponseData data;


    @Data
    @NoArgsConstructor
    public static class ResponseData{
        @JsonProperty("account")
        private List<Account> accountList;

    }

    @Data
    @NoArgsConstructor
    public static class Account{
        private long accountNumber;
        private int userId;
        private double currentBalance;
        private String lastName;

    }

}
