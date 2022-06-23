package com.abc.accountservice.service;

import com.abc.accountservice.common.response.ApiResponse;
import com.abc.accountservice.model.Account;

public interface AccountService {

    ApiResponse getAccountNumber(Account account);

    ApiResponse getAccountById(int userId);

    ApiResponse updateBalance(int userId,Account account);



    ApiResponse getBeneficiaryAccount();
}
