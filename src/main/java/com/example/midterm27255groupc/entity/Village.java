package com.example.midterm27255groupc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Village {
    @Id
    private String code;
    private String name;

    @ManyToOne
    @JoinColumn(name = "cell_code")
    private Cell cell;

    public Village() {}

    public Village(String code, String name, Cell cell) {
        this.code = code;
        this.name = name;
        this.cell = cell;
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

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
