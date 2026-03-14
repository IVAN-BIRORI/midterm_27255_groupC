package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.Cell;
import com.example.midterm27255groupc.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CellService {
    @Autowired
    private CellRepository cellRepository;

    public Cell saveCell(Cell cell) {
        return cellRepository.save(cell);
    }
}