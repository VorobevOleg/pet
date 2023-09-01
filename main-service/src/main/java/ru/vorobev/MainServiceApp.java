package ru.vorobev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Точка входа, основное приложение Spring Boot для хранения и использования инфы
 */
@SpringBootApplication
@EnableCaching
public class MainServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(MainServiceApp.class, args);
        System.out.println("Hello from main-service. I'm alive :)");
    }
}