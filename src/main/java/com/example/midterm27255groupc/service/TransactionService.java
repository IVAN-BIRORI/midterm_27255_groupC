package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.Transaction;
import com.example.midterm27255groupc.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}