package com.example.midterm27255groupc.controller;

import com.example.midterm27255groupc.entity.Cell;
import com.example.midterm27255groupc.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cells")
public class CellController {
    @Autowired
    private CellService cellService;

    @PostMapping
    public Cell saveCell(@RequestBody Cell cell) {
        return cellService.saveCell(cell);
    }
}