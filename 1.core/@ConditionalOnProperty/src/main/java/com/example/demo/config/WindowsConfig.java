package com.example.demo.config;

import com.example.demo.service.WindowsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "app.os", havingValue = "windows")
public class WindowsConfig {
    @Bean
    public WindowsService windowsService() {
        return new WindowsService();
    }
}
