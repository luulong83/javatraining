package com.example.demo.config;

import com.example.demo.service.LinuxService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "app.os", havingValue = "linux")
public class LinuxConfig {
    @Bean
    public LinuxService linuxService() {
        return new LinuxService();
    }
}
