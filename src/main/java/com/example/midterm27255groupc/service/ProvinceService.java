package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.Province;
import com.example.midterm27255groupc.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    public Province saveProvince(Province province) {
        return provinceRepository.save(province);
    }
}