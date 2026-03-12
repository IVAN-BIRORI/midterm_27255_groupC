package com.example.midterm27255groupc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Province {
    @Id
    private String code;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "province")
    private List<District> districts;

    @JsonIgnore
    @OneToMany(mappedBy = "province")
    private List<User> users;

    public Province() {}

    public Province(String code, String name) {
        this.code = code;
        this.name = name;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}