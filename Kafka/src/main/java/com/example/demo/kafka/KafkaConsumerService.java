package com.example.demo.kafka;

import com.example.demo.dto.UserDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "user-topic",
            groupId = "user-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(UserDto user) {
        System.out.println("Received from Kafka: " + user);
    }
}

