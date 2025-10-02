package com.example.demo.service;

import com.example.demo.dto.UserDto;
import java.util.List;

public interface UserService {

    // Lưu user mới
    UserDto saveUser(UserDto user);

    // Cập nhật user theo id
    UserDto updateUser(Long id, UserDto user);

    // Lấy user theo id
    UserDto getUser(Long id);

    // Lấy tất cả user
    List<UserDto> getAllUsers();

    // Xóa user theo id
    void deleteUser(Long id);
}

