package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.District;
import com.example.midterm27255groupc.entity.Sector;
import com.example.midterm27255groupc.repository.DistrictRepository;
import com.example.midterm27255groupc.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public Sector saveSector(Sector sector) {
        if (sector.getDistrict() != null && sector.getDistrict().getCode() != null) {
            District district = districtRepository.findById(sector.getDistrict().getCode())
                    .orElseThrow(() -> new RuntimeException("District not found"));
            sector.setDistrict(district);
        }
        return sectorRepository.save(sector);
    }

    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }
}
