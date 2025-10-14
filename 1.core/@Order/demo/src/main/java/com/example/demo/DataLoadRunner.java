package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class DataLoadRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔹 [2] Đang load dữ liệu mẫu...");
        Thread.sleep(500); // giả lập chờ
        System.out.println("✅ Dữ liệu mẫu đã load xong!");
    }
}
