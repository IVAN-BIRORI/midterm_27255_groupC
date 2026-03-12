package com.example.midterm27255groupc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
public class District {
    @Id
    private String code;
    private String name;

    @ManyToOne
    @JoinColumn(name = "province_code")
    private Province province;

    @JsonIgnore
    @OneToMany(mappedBy = "district")
    private List<Sector> sectors;

    public District() {}

    public District(String code, String name, Province province) {
        this.code = code;
        this.name = name;
        this.province = province;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }
}