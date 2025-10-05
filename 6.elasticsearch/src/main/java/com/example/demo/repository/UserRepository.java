package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
    // Bạn có thể thêm các phương thức tìm kiếm tùy chỉnh
    // Ví dụ: tìm theo email
    User findByEmail(String email);
}
