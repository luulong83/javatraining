package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    // Giả lập DB tạm thời
    private final ConcurrentHashMap<Long, UserDto> database = new ConcurrentHashMap<>();

    // Tự động tạo ID
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    @CachePut(value = "users", key = "#user.id")
    public UserDto saveUser(UserDto user) {
        if (user.getId() == null) {
            user.setId(idGenerator.getAndIncrement());
        }
        database.put(user.getId(), user);
        return user;
    }

    @Override
    @CachePut(value = "users", key = "#id")
    public UserDto updateUser(Long id, UserDto user) {
        if (!database.containsKey(id)) {
            throw new IllegalArgumentException("User với id " + id + " không tồn tại");
        }
        user.setId(id);
        database.put(id, user);
        return user;
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    public UserDto getUser(Long id) {
        return database.get(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        database.remove(id);
    }
}
