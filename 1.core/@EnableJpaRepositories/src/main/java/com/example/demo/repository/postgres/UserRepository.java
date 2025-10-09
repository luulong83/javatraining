package com.example.demo.repository.postgres;

import com.example.demo.entity.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
