package com.abc.accountservice.service.impl;

import com.abc.accountservice.common.response.ApiResponse;
import com.abc.accountservice.integration.repository.AccountRepository;
import com.abc.accountservice.model.Account;
import com.abc.accountservice.model.TransactionResponse;
import com.abc.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import java.util.*;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

        private AccountRepository accountRepository;

        private RestTemplate restTemplate;



    @Override
    public ApiResponse getAccountNumber(Account account) {
        ApiResponse apiResponse = new ApiResponse();
        Map<String, Account> data = new HashMap<>();

        Random rng = new Random();
        long first14 = (rng.nextLong() % 100000000000000L) + 5200000000000000L;
        int balance =  rng.nextInt(900000) + 100000;

        account.setAccountNumber(first14);
        account.setUserId(account.getUserId());
        account.setCurrentBalance(balance);
        account.setLastName(account.getLastName());

        accountRepository.save(account);

        data.put("account", account);

        apiResponse.setData(data);

        return apiResponse;
    }

    @Override
    public ApiResponse getAccountById(int userId) {
        ApiResponse apiResponse = new ApiResponse();
        Account account= accountRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("ID not found"));

        Map<String, Account> data = new HashMap<>();
        data.put("customer", account);
        apiResponse.setData(data);
        return apiResponse;
    }

    @Override
    public ApiResponse updateBalance(int userId,Account account) {

//        final String url = "http://localhost:8079/api/transaction/"+userId;
//        ResponseEntity<TransactionResponse> response = restTemplate.getForEntity(url,TransactionResponse.class);
//        double totalTransaction =0;
//        Map<Long, Double> senderDetails = new HashMap<>();
//        Map<Long, Double> receiverDetails = new HashMap<>();
//        for(TransactionResponse.Transaction tr: response.getBody().getData().getTransactionList()){
//            totalTransaction += tr.getAmount();
//            senderDetails.put(tr.getSenderAccountNumber(), totalTransaction);
//            receiverDetails.put(tr.getReceiverAccountNumber(), totalTransaction);
//        }
//
//        Map.Entry<Long, Double> senderEntry = senderDetails.entrySet().iterator().next();
//        Account senderAccountNumber = accountRepository.findByAccountNumber(senderEntry.getKey()).orElseThrow(()->
//                 new NoSuchElementException("account number does not exist"));
//        senderAccountNumber.setCurrentBalance(senderAccountNumber.getCurrentBalance() - senderEntry.getValue());
//        accountRepository.save(senderAccountNumber);
//
//        Map.Entry<Long, Double> recevierEntry = receiverDetails.entrySet().iterator().next();
//        Account recevierAccountNumber = accountRepository.findByAccountNumber(recevierEntry.getKey()).orElseThrow(()->
//                new NoSuchElementException("account number does not exist"));
//        recevierAccountNumber.setCurrentBalance(recevierAccountNumber.getCurrentBalance() + recevierEntry.getValue());
//        accountRepository.save(recevierAccountNumber);

        ApiResponse apiResponse = new ApiResponse();
//        Map<String,Double>  data = new HashMap<>();
//        data.put("current-balance",account.getCurrentBalance());


        return apiResponse;

    }

    @Override
    public ApiResponse getBeneficiaryAccount() {
        ApiResponse apiResponse = new ApiResponse();
        List<Account> accounts = accountRepository.findAll();
        Map<String, List<Account>> data= new HashMap<>();
        data.put("account", accounts);
        apiResponse.setData(data);
        return apiResponse;
    }
}
