package com.example.midterm27255groupc.controller;

import com.example.midterm27255groupc.entity.User;
import com.example.midterm27255groupc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/exists")
    public boolean existsByEmail(@RequestParam String email) {
        return userService.existsByEmail(email);
    }

    @GetMapping("/province/code/{code}")
    public List<User> getUsersByProvinceCode(@PathVariable String code) {
        return userService.getUsersByProvinceCode(code);
    }

    @GetMapping("/province/name/{name}")
    public List<User> getUsersByProvinceName(@PathVariable String name) {
        return userService.getUsersByProvinceName(name);
    }

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return userService.getUsers(pageable);
    }
}