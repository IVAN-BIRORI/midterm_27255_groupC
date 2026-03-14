package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.Village;
import com.example.midterm27255groupc.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VillageService {
    @Autowired
    private VillageRepository villageRepository;

    public Village saveVillage(Village village) {
        return villageRepository.save(village);
    }
}