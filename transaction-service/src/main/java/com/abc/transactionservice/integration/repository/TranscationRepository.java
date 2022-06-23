package com.abc.transactionservice.integration.repository;

import com.abc.transactionservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TranscationRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByUserId(int userId);
}
