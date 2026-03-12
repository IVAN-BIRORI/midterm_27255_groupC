package com.example.midterm27255groupc.repository;

import com.example.midterm27255groupc.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    List<User> findByProvinceCode(String code);

    List<User> findByProvinceName(String name);

    Page<User> findAll(Pageable pageable);
}