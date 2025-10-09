package com.example.demo.entity.postgres;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructor mặc định
    public User() {}

    // Nếu muốn tạo User với name
    public User(String name) {
        this.name = name;
    }

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
