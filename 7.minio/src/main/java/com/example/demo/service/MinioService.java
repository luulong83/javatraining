package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface MinioService {
    String uploadFile(MultipartFile file);

    InputStream downloadFile(String fileName);
}
