package ru.vorobev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входа, основное приложение Spring Boot для хранения и использования инфы
 */
@SpringBootApplication
public class MainServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(MainServiceApp.class, args);
        System.out.println("Hello from main-service. I'm alive :)");
    }
}