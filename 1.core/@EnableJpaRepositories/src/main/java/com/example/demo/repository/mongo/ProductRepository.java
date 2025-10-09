package com.example.demo.repository.mongo;

import com.example.demo.entity.mongo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

