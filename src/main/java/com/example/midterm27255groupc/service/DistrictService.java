package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.District;
import com.example.midterm27255groupc.entity.Province;
import com.example.midterm27255groupc.repository.DistrictRepository;
import com.example.midterm27255groupc.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public District saveDistrict(District district) {
        if (district.getProvince() != null && district.getProvince().getCode() != null) {
            Province province = provinceRepository.findById(district.getProvince().getCode())
                    .orElseThrow(() -> new RuntimeException("Province not found"));
            district.setProvince(province);
        }
        return districtRepository.save(district);
    }

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
}
