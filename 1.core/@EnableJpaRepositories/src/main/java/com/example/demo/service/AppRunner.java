package com.example.demo.service;

import com.example.demo.entity.mongo.Product;
import com.example.demo.entity.postgres.User;
import com.example.demo.repository.mongo.ProductRepository;
import com.example.demo.repository.postgres.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public AppRunner(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // PostgreSQL
        User user = new User("Alice");
        userRepository.save(user);
        System.out.println("Saved User: " + user.getName());

        // MongoDB
        Product product = new Product("Laptop");
        productRepository.save(product);
        System.out.println("Saved Product: " + product.getName());
    }
}
