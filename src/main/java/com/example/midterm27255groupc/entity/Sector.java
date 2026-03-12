package com.example.midterm27255groupc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
public class Sector {
    @Id
    private String code;
    private String name;

    @ManyToOne
    @JoinColumn(name = "district_code")
    private District district;

    @JsonIgnore
    @OneToMany(mappedBy = "sector")
    private List<Cell> cells;

    public Sector() {}

    public Sector(String code, String name, District district) {
        this.code = code;
        this.name = name;
        this.district = district;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}