package com.example.midterm27255groupc.controller;

import com.example.midterm27255groupc.entity.Sector;
import com.example.midterm27255groupc.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @PostMapping
    public Sector saveSector(@RequestBody Sector sector) {
        return sectorService.saveSector(sector);
    }
}