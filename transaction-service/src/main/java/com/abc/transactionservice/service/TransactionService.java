package com.abc.transactionservice.service;

import com.abc.transactionservice.common.response.ApiResponse;
import com.abc.transactionservice.model.Transaction;

import java.util.LinkedHashMap;

public interface TransactionService {

    ApiResponse create(Transaction transaction);
    ApiResponse getAllTransactionByUserId(int userId);
}
