package com.example.demo;

import com.example.demo.service.DefaultService;
import com.example.demo.service.LinuxService;
import com.example.demo.service.WindowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired(required = false)
    private WindowsService windowsService;

    @Autowired(required = false)
    private LinuxService linuxService;

    @Autowired(required = false)
    private DefaultService defaultService;

    @Override
    public void run(String... args) {
        if (windowsService != null) windowsService.printMessage();
        else if (linuxService != null) linuxService.printMessage();
        else if (defaultService != null) defaultService.printMessage();
    }
}
