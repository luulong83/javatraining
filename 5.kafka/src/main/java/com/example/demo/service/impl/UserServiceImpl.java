package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.kafka.KafkaProducerService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final KafkaProducerService kafkaProducer;

    public UserServiceImpl(KafkaProducerService kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        kafkaProducer.sendMessage("user-topic", userDto);
        return userDto;
    }
}


