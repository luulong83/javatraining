package com.example.demo.kafka;


import com.example.demo.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, UserDto> kafkaTemplate;

    public void sendMessage(String topic, UserDto user) {
        kafkaTemplate.send(topic, user);
    }
}
