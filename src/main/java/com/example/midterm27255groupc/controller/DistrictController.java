package com.example.midterm27255groupc.controller;

import com.example.midterm27255groupc.entity.District;
import com.example.midterm27255groupc.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping
    public District saveDistrict(@RequestBody District district) {
        return districtService.saveDistrict(district);
    }
}