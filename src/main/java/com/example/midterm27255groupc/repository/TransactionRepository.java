package com.example.midterm27255groupc.repository;

import com.example.midterm27255groupc.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
