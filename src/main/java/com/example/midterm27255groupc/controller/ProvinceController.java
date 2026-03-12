package com.example.midterm27255groupc.controller;

import com.example.midterm27255groupc.entity.Province;
import com.example.midterm27255groupc.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @PostMapping
    public Province saveProvince(@RequestBody Province province) {
        return provinceService.saveProvince(province);
    }
}