package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DatabaseInitRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔹 [1] Kết nối Database...");
        Thread.sleep(500); // giả lập chờ
        System.out.println("✅ Database sẵn sàng!");
    }
}
