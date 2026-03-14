package com.example.midterm27255groupc.service;

import com.example.midterm27255groupc.entity.User;
import com.example.midterm27255groupc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public List<User> getUsersByProvinceCode(String code) {
        return userRepository.findByProvinceCode(code);
    }

    public List<User> getUsersByProvinceName(String name) {
        return userRepository.findByProvinceName(name);
    }

    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}