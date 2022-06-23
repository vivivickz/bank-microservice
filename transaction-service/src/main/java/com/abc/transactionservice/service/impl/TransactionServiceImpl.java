package com.abc.transactionservice.service.impl;

import com.abc.transactionservice.common.response.ApiResponse;
import com.abc.transactionservice.integration.repository.TranscationRepository;
import com.abc.transactionservice.model.AccountResponse;
import com.abc.transactionservice.model.Transaction;
import com.abc.transactionservice.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TranscationRepository transcationRepository;
    private RestTemplate restTemplate;
    @Override
    public ApiResponse create(Transaction transaction) {
        ApiResponse apiResponse = new ApiResponse();


        Long senderAccountNumber = transaction.getSenderAccountNumber();
        Long receiverAccountNumber = transaction.getReceiverAccountNumber();
        final String url = "http://localhost:8080/api/account/beneficiary/all";

        ResponseEntity<AccountResponse> response = restTemplate.getForEntity(url,AccountResponse.class);
        List<Long> accountNumbers = new ArrayList<>();
        for(AccountResponse.Account ac : response.getBody().getData().getAccountList()){
            accountNumbers.add(ac.getAccountNumber());
        }

        if(accountNumbers.contains(senderAccountNumber) && accountNumbers.contains(receiverAccountNumber)){
            if(isAmountAvailable(senderAccountNumber,transaction.getAmount())){
                transaction.setTransactionId(transaction.getTransactionId());
                transaction.setTransactionDate(transaction.getTransactionDate());
                transaction.setSenderAccountNumber(transaction.getSenderAccountNumber());
                transaction.setReceiverAccountNumber(transaction.getReceiverAccountNumber());
                transaction.setRemarks(transaction.getRemarks());
                transaction.setAmount(transaction.getAmount());

               updateAccount(senderAccountNumber,receiverAccountNumber, transaction.getAmount(),transaction);

                transcationRepository.save(transaction);

                apiResponse.setStatus("Success");
                apiResponse.setData("Amount transferred");
                apiResponse.setError("null");

                return apiResponse;
            }
            else{
                apiResponse.setStatus("Error");
                apiResponse.setData("Insufficient Fund");
                apiResponse.setError("Check your balance");

            }
        }else{
            apiResponse.setStatus("Error");
            apiResponse.setData("Account Number Not Valid");
            apiResponse.setError("Please Try Again");
        }
        return apiResponse;
    }

    private void updateAccount(Long senderAccountNumber, Long receiverAccountNumber, Double amount,Transaction transaction) {
        final String url = "http://localhost:8080/api/account/beneficiary/all";
        ResponseEntity<AccountResponse> response = restTemplate.getForEntity(url,AccountResponse.class);

        Map<Long, Double> accountBalance = new HashMap<>();
        for(AccountResponse.Account ac: response.getBody().getData().getAccountList()){
            accountBalance.put(ac.getAccountNumber(), ac.getCurrentBalance());
        }

        Double updatedSender = accountBalance.get(senderAccountNumber) - amount ;
        System.out.println(updatedSender);

        Double updatedReceiver = accountBalance.get(receiverAccountNumber) + amount ;
        System.out.println(updatedReceiver);


    }

    private boolean isAmountAvailable(Long accNo, Double amount) {
        final String url = "http://localhost:8080/api/account/beneficiary/all";
        ResponseEntity<AccountResponse> response = restTemplate.getForEntity(url,AccountResponse.class);
        Map<Long, Double> accountBalance = new HashMap<>();

        for(AccountResponse.Account ac : response.getBody().getData().getAccountList()){
            accountBalance.put(ac.getAccountNumber(),ac.getCurrentBalance());
        }
        if(accountBalance.get(accNo) >= amount){
            return true;
        }
        return false;
    }
    @Override
    public ApiResponse getAllTransactionByUserId(int userId) {
        ApiResponse apiResponse = new ApiResponse();
        List<Transaction> transaction =transcationRepository.findByUserId(userId);
        if(transaction.isEmpty()){
            throw new NoSuchElementException("User Not found");
        }
        Map<String,List<Transaction>> data = new HashMap<>();
        data.put("transaction-details", transaction);
        apiResponse.setData(data);
        return apiResponse;
    }
}
