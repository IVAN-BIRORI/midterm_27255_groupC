package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.Wallet;
import com.example.midterm27255groupc.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}