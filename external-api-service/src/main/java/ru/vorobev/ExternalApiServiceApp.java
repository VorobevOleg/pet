package ru.vorobev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входа, основное приложение Spring Boot для взаимодействия со внешними API
 */
@SpringBootApplication
public class ExternalApiServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ExternalApiServiceApp.class, args);
        System.out.println("Hello from external-api-service. I'm alive :)");
    }
}