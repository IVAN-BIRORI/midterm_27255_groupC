package com.example.midterm27255groupc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
public class Cell {
    @Id
    private String code;
    private String name;

    @ManyToOne
    @JoinColumn(name = "sector_code")
    private Sector sector;

    @JsonIgnore
    @OneToMany(mappedBy = "cell")
    private List<Village> villages;

    public Cell() {}

    public Cell(String code, String name, Sector sector) {
        this.code = code;
        this.name = name;
        this.sector = sector;
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Village> getVillages() {
        return villages;
    }

    public void setVillages(List<Village> villages) {
        this.villages = villages;
    }
}