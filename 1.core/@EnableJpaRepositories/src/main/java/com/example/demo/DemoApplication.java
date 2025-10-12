package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", "Asia/Ho_Chi_Minh");
		SpringApplication.run(DemoApplication.class, args);
	}

}
