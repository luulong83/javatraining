package com.example.demo.config;

import com.example.demo.condition.WindowsCondition;
import com.example.demo.service.WindowsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(WindowsCondition.class)
public class WindowsConfig {
    @Bean
    public WindowsService windowsService() {
        return new WindowsService();
    }
}
