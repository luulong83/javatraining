package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Data
@Document(indexName = "users") // Tên index trong Elasticsearch
public class User {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String email;

    private String password;
}


