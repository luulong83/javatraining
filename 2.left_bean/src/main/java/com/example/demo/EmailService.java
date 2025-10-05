package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Lazy
@Component
public class EmailService implements MessageService {

    public EmailService(){
        System.out.println("\u001B[32m::: EmailService Constructor Called\u001B[0m");
    }
    @Override
    public void SendMessage(String msg) {
        System.out.println("\u001B[32m::: Email Message Sent: \u001B[0m" + msg);
    }

    // @PostConstruct: Chay SAU constructor + inject DI (khoi tao)
    @PostConstruct
    public void init() {  // Ten method tu y, Spring goi tu dong
        System.out.println("\u001B[32m::: @PostConstruct:::: EmailService đã sẵn sàng! Load config... ---\u001B[0m");
        // Them code: Mo ket noi DB, load cache, etc.
    }

    // @PreDestroy: Chay TRUOC khi Spring huy bean (don dep)
    @PreDestroy
    public void cleanup() {
        System.out.println("\u001B[32m::: @PreDestroy: Dang dong ket noi, save log... Goodbye! ---\u001B[0m");
        // Them code: Dong DB, flush cache, etc.
    }
}
