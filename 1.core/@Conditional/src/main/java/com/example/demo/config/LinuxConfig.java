package com.example.demo.config;

import com.example.demo.condition.LinuxCondition;
import com.example.demo.service.LinuxService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(LinuxCondition.class)
public class LinuxConfig {
    @Bean
    public LinuxService linuxService() {
        return new LinuxService();
    }
}
