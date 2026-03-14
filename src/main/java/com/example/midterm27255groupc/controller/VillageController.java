package com.example.midterm27255groupc.controller;

import com.example.midterm27255groupc.entity.Village;
import com.example.midterm27255groupc.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/villages")
public class VillageController {
    @Autowired
    private VillageService villageService;

    @PostMapping
    public Village saveVillage(@RequestBody Village village) {
        return villageService.saveVillage(village);
    }
}