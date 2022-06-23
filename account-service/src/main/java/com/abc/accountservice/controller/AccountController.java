package com.abc.accountservice.controller;

import com.abc.accountservice.common.response.ApiResponse;
import com.abc.accountservice.model.Account;
import com.abc.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping("/create-account")
    public ApiResponse getAccountNumber(@RequestBody Account account){

        return accountService.getAccountNumber(account);
    }
    @GetMapping("/{userId}")
    public ApiResponse getAccountById(@PathVariable("userId") int userId){
        return  accountService.getAccountById(userId);
    }
    @GetMapping("/beneficiary/all")
    public ApiResponse getBeneficiaryAccount(){
        return accountService.getBeneficiaryAccount();
    }

    @GetMapping("/update-balance/{userId}")
    public  ApiResponse updateBalance(@PathVariable("userId") int userId , Account account){
        return accountService.updateBalance(userId,account);
    }
}
