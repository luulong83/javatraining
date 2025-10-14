package com.example.demo;

import com.example.demo.Orders.Girl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo", "com.example.demo.Orders"})
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		/*
		EmailService emailService = new EmailService();
		emailService.SendMessage("Hello World");
		*/
//		EmailService emailService = context.getBean(EmailService.class);
//		emailService.SendMessage("Hello, this is a test message!");

		System.out.println("\u001B[32m::: SAU KHI RUN XONG APP!!!\u001B[0m");
		/*------------------------------------------------------------------*/
		EmailService emailService = context.getBean(EmailService.class);
		System.out.println("\u001B[32m::: EmailService Bean: \u001B[0m" + emailService);

		AppConfig appConfig = context.getBean(AppConfig.class);
		System.out.println("\u001B[32m::: AppConfig Bean: \u001B[0m" + appConfig);

//		//BoyObjectMapper boyObjectMapper = context.getBean(BoyObjectMapper.class);
//		//System.out.println("AppConfig Bean: " + boyObjectMapper);

		// ComponentScan
		Girl girl = context.getBean(Girl.class);
		System.out.println("Girl Bean: "+  girl);

	}
}
