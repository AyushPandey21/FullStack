package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }
}

@RestController
class HelloController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot! 🚀";
    }

    @GetMapping("/api/welcome")
    public String welcome() {
        return "Welcome to Spring Boot REST API";
    }

    @GetMapping("/api/info")
    public String info() {
        return "This is your first Spring Boot application running on Java 21!";
    }

    @GetMapping("/api/repository-class")
    public String showRepositoryClass() {
        // This will show the actual class Spring created for TodoRepository
        return "TodoRepository actual class: " + todoRepository.getClass().getName() + 
               "\n\nThis is Spring's auto-generated proxy class, not a file in your codebase!";
    }
}
