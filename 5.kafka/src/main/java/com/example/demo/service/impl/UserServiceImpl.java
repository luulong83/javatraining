package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.kafka.KafkaProducerService;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KafkaProducerService kafkaProducer; // <-- thêm dòng này

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, KafkaProducerService kafkaProducer) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.kafkaProducer = kafkaProducer; // <-- thêm dòng này
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User entity = userMapper.toEntity(userDto);
        entity.setPassword("123456");
        User saved = userRepository.save(entity);

        // gửi lên Kafka
        kafkaProducer.sendMessage("user-topic", userMapper.toDto(saved));


        return userMapper.toDto(saved);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users); // giờ OK
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existing.setName(userDto.getName());
        existing.setEmail(userDto.getEmail());

        User updated = userRepository.save(existing);
        return userMapper.toDto(updated);
    }
}

