package com.abc.transactionservice.controller;

import com.abc.transactionservice.common.response.ApiResponse;
import com.abc.transactionservice.model.Transaction;
import com.abc.transactionservice.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transaction")
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @GetMapping("/create")
    public ApiResponse create(@Valid @RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }
    @GetMapping("/{userId}")
    public ApiResponse getAllTransactionByUserId(@PathVariable("userId") int userId){
        return transactionService.getAllTransactionByUserId(userId);
    }
}
