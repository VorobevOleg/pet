package ru.vorobev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExternalApiServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ExternalApiServiceApp.class, args);
        System.out.println("Hello from external-api-service");
    }
}