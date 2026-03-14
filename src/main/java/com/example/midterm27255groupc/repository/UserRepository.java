package com.example.midterm27255groupc.repository;

import com.example.midterm27255groupc.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.village.cell.sector.district.province.code = :code")
    List<User> findByProvinceCode(String code);

    @Query("SELECT u FROM User u WHERE u.village.cell.sector.district.province.name = :name")
    List<User> findByProvinceName(String name);

    Page<User> findAll(Pageable pageable);
}