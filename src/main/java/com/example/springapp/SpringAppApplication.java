package com.example.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.rest", "com.example.config"})
public class SpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);
    }

}
