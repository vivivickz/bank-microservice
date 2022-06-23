package com.abc.accountservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class TransactionResponse {

    private  String status;
    private Object error;
    private ResponseData data;
    @Data
    @NoArgsConstructor
    public  static class ResponseData{
        @JsonProperty("transaction-details")
        private List<Transaction> transactionList;
    }
    @Data
    @NoArgsConstructor
    public static class Transaction {


        private Integer transactionId;

        private Integer userId;
        private Date transactionDate;
        private Long senderAccountNumber;
        private Long receiverAccountNumber;
        private String remarks;
        private Double updateSenderBalance;
        private Double updateReceiverBalance;

        private Double amount;
    }

}
