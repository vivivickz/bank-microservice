package com.abc.accountservice.integration.repository;

import com.abc.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

    Optional<Account> findByUserId(int userId);
    Optional<Account> findByAccountNumber(Long accountNumber);

}
