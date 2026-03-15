# Level 2: Spring Boot Basics

Great! You've mastered Java fundamentals. Now let's build web applications with Spring Boot!

## 📖 What is Spring Boot?

**Spring Boot** is a framework that makes building Java web applications easy. It:
- Simplifies configuration
- Builds REST APIs quickly
- Manages databases with JPA/Hibernate
- Handles HTTP requests and responses
- Provides built-in server (Tomcat)

## 📂 Topics Covered

1. Spring Boot Setup & Configuration
2. Creating Your First REST API
3. HTTP Methods (GET, POST, PUT, DELETE)
4. Request and Response handling
5. Database integration (BasicSQL)
6. Error handling

## ⏱️ Duration

**2-3 weeks** of focused study and practice

## 📂 Folder Structure

```
2-spring-boot-basics/
├── README.md (this file)
├── 1-setup-first-app/
│   ├── create-spring-boot-app.md
│   └── FirstSpringApp/
├── 2-rest-api-basics/
│   ├── rest-api-theory.md
│   └── StudentAPI/
├── 3-database-integration/
│   ├── database-setup.md
│   └── BlogAPI/
├── 4-advanced-features/
│   ├── exception-handling.md
│   └── AdvancedAPI/
└── exercises/
    ├── Exercise1-CreateAPI.md
    ├── Exercise2-Database.md
    └── Exercise3-MiniProject.md
```

## 🎯 Learning Outcomes

By the end of this level, you'll:
- ✅ Create REST APIs with Spring Boot
- ✅ Handle HTTP requests
- ✅ Connect to databases
- ✅ Implement CRUD operations
- ✅ Handle errors gracefully

## 🚀 Quick Start: Create Your First Spring Boot App

### Step 1: Generate Project using Maven

```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=HelloSpringBoot -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

### Step 2: Add Spring Boot Dependencies

Edit `pom.xml` and add:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.2.0</version>
    </dependency>
    
    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>3.2.0</version>
    </dependency>
    
    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.0</version>
    </dependency>
</dependencies>
```

### Step 3: Create Main Application Class

```java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }
}
```

### Step 4: Create Your First Controller

```java
package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }
}
```

### Step 5: Run the Application

```bash
mvn spring-boot:run
```

### Step 6: Test Your API

Open browser or use curl:
```bash
curl http://localhost:8080/api/hello
```

**Expected response:**
```
Hello from Spring Boot!
```

---

## 📚 Key Spring Boot Concepts

### 1. REST API Basics

```
REST = Representational State Transfer

HTTP Methods:
- GET      = Read/Retrieve data
- POST     = Create new data
- PUT/PATCH= Update existing data
- DELETE   = Delete data
```

### 2. Spring Annotations

```java
@RestController       // Marks class as REST controller
@RequestMapping()     // Maps HTTP requests to handler methods
@GetMapping()         // Maps GET requests
@PostMapping()        // Maps POST requests
@PutMapping()         // Maps PUT requests
@DeleteMapping()      // Maps DELETE requests
@PathVariable         // Extracts values from URL
@RequestBody          // Deserializes JSON to object
```

### 3. Example: Complete CRUD API

```java
@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        // Return all students
    }
    
    // GET student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        // Return specific student
    }
    
    // CREATE new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        // Create and return new student
    }
    
    // UPDATE student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        // Update and return student
    }
    
    // DELETE student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        // Delete student
    }
}
```

---

## 📝 Week-by-Week Breakdown

### Week 1: Spring Boot Setup & REST Basics
- Install Spring Boot
- Create first REST API
- Learn annotations
- Build simple GET endpoints

### Week 2: Complete CRUD Operations
- POST, PUT, DELETE endpoints
- Request/Response handling
- JSON serialization
- Testing endpoints

### Week 3: Database & Production
- Connect to database
- Entity and Repository
- Database migrations
- Error handling

---

## ✅ Level 2 Checklist

Before moving to Level 3, ensure you:
- [ ] Spring Boot installed and working
- [ ] Created first REST API
- [ ] Understand all HTTP methods
- [ ] Can implement CRUD endpoints
- [ ] Can connect to database
- [ ] Can test APIs with curl/Postman
- [ ] Completed all exercises

---

## 🔗 Next Level

Once comfortable with Spring Boot basics:
[Level 3: Angular Basics](../3-angular-basics/README.md)

---

## 📚 Resources

- **Spring Boot Official**: https://spring.io/projects/spring-boot
- **Spring Guides**: https://spring.io/guides
- **Baeldung Spring Boot**: https://www.baeldung.com/spring-boot
- **Spring Boot Docs**: https://docs.spring.io/spring-boot/
