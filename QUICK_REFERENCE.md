# Quick Reference Guide

A comprehensive quick reference for Java, Spring Boot, and Angular development.

## 🔤 Java Quick Reference

### Variables & Types

```java
// Primitive Types
int age = 25;                    // Whole numbers: -2^31 to 2^31-1
long bigNumber = 1000000000L;    // Large whole numbers
double salary = 50000.50;        // Decimal numbers
float temp = 36.5f;              // Single precision decimal
boolean isActive = true;         // True or False
char grade = 'A';                // Single character

// String (Reference type)
String name = "John";            // Text

// Arrays
int[] numbers = {1, 2, 3, 4};   // Fixed size
String[] names = new String[5];  // Pre-allocated array

// Collections
List<String> list = new ArrayList<>();
Map<String, Integer> map = new HashMap<>();
Set<Integer> set = new HashSet<>();
```

### Operators

```java
// Arithmetic
int sum = 10 + 5;        // 15
int diff = 10 - 5;       // 5
int product = 10 * 5;    // 50
int quotient = 10 / 3;   // 3
int remainder = 10 % 3;  // 1

// Comparison
10 > 5;   // true
10 < 5;   // false
10 == 5;  // false
10 != 5;  // true

// Logical
true && true;    // AND
true || false;   // OR
!true;          // NOT
```

### Control Flow

```java
// If-Else
if (age >= 18) {
    System.out.println("Adult");
} else if (age >= 13) {
    System.out.println("Teenager");
} else {
    System.out.println("Child");
}

// Switch
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Other");
}

// For Loop
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// While Loop
while (condition) {
    // code
}

// Do-While
do {
    // code
} while (condition);

// For-Each
for (String name : names) {
    System.out.println(name);
}
```

### Methods

```java
// Simple method
public static void greet() {
    System.out.println("Hello!");
}

// Method with parameters
public static void greet(String name) {
    System.out.println("Hello, " + name);
}

// Method with return value
public static int add(int a, int b) {
    return a + b;
}

// Method overloading (same name, different parameters)
public static void print(int num) {
    System.out.println("Int: " + num);
}

public static void print(String text) {
    System.out.println("String: " + text);
}
```

### Classes and Objects

```java
class Person {
    // Properties
    String name;
    int age;
    
    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Method
    void displayInfo() {
        System.out.println(name + ", " + age);
    }
}

// Create object
Person person = new Person("Alice", 30);
person.displayInfo();
```

### String Operations

```java
String text = "Hello";

text.length();              // 5
text.charAt(0);            // 'H'
text.substring(1, 4);      // "ell"
text.toUpperCase();        // "HELLO"
text.toLowerCase();        // "hello"
text.contains("ell");      // true
text.replace("l", "l");    // "Helo"
text.split(",");           // String array

// String concatenation
String result = "Hello" + " " + "World";  // "Hello World"
String result2 = String.format("Number: %d", 42);
```

---

## 🌐 Spring Boot Quick Reference

### Project Creation

```bash
# Using Spring Boot CLI
spring boot new --from=rest HelloApp

# Using Maven
mvn archetype:generate -DgroupId=com.example -DartifactId=app

# Using Spring Initializr
# Visit: https://start.spring.io/
```

### Essential Dependencies (pom.xml)

```xml
<!-- Web starter (REST APIs) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Data JPA (Database) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- PostgreSQL Driver -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>

<!-- Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### Application Properties

```properties
# Server
server.port=8080
server.servlet.context-path=/api

# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Logging
logging.level.root=INFO
logging.level.com.example=DEBUG
```

### Controllers and Endpoints

```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    // GET all
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
    
    // GET by ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }
    
    // POST - Create
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }
    
    // PUT - Update
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    
    // With query parameters
    @GetMapping("/search")
    public List<User> search(@RequestParam String name) {
        return userService.searchByName(name);
    }
}
```

### Entity (Database Model)

```java
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true)
    private String email;
    
    private int age;
    
    // Constructors, Getters, Setters
}
```

### Repository (Data Access)

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Automatic CRUD methods from JpaRepository
    
    // Custom queries using Spring Data keywords
    User findByEmail(String email);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByNameContaining(String name);
    
    // Custom JPQL
    @Query("SELECT u FROM User u WHERE u.age > ?1")
    List<User> findAdults(int age);
}
```

### Service (Business Logic)

```java
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.findAll();
    }
    
    public User getById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }
    
    public User save(User user) {
        return userRepository.save(user);
    }
    
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
```

### Error Handling

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(EntityNotFoundException e) {
        return Map.of("error", e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGeneral(Exception e) {
        return Map.of("error", "Internal server error");
    }
}
```

---

## 🎨 Angular Quick Reference

### Project Commands

```bash
# Create new project
ng new MyApp

# Serve development server
ng serve

# Generate component
ng generate component mycomponent

# Generate service
ng generate service myservice

# Build for production
ng build --prod
```

### TypeScript Types

```typescript
// Basic types
let name: string = "John";
let age: number = 25;
let active: boolean = true;

// Arrays
let numbers: number[] = [1, 2, 3];
let strings: Array<string> = ["a", "b"];

// Any type (avoid when possible)
let data: any = "anything";

// Union types
let value: string | number = 42;

// Interfaces
interface User {
    name: string;
    age: number;
    email?: string;  // Optional
}

const user: User = {
    name: "Alice",
    age: 30
};
```

### Components

```typescript
import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'app-hello',
    templateUrl: './hello.component.html',
    styleUrls: ['./hello.component.css']
})
export class HelloComponent {
    // Data
    message: string = 'Hello';
    count: number = 0;
    
    // Input - receive from parent
    @Input() title: string = '';
    
    // Output - send to parent
    @Output() countChanged = new EventEmitter<number>();
    
    // Lifecycle
    ngOnInit() {
        // Called when component initializes
    }
    
    // Methods
    increment() {
        this.count++;
        this.countChanged.emit(this.count);
    }
}
```

### Templates (HTML)

```html
<!-- Interpolation (Display data) -->
<h1>{{ message }}</h1>

<!-- Property binding -->
<img [src]="imageUrl" />
<button [disabled]="isDisabled">Click</button>

<!-- Event binding -->
<button (click)="increment()">+</button>
<input (keyup)="onKeyUp($event)" />

<!-- Two-way binding -->
<input [(ngModel)]="name" />

<!-- Conditional rendering -->
<div *ngIf="isLoggedIn">Welcome</div>
<div *ngIf="role === 'admin'; else notAdmin">Admin</div>
<ng-template #notAdmin>Not Admin</ng-template>

<!-- Loops -->
<div *ngFor="let item of items">
    {{ item }}
</div>

<!-- Class binding -->
<div [class.active]="isActive">Content</div>

<!-- Style binding -->
<div [style.color]="textColor">Red text</div>
```

### Services and HTTP

```typescript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DataService {
    private apiUrl = 'http://localhost:8080/api';
    
    constructor(private http: HttpClient) {}
    
    // GET request
    getUsers(): Observable<User[]> {
        return this.http.get<User[]>(`${this.apiUrl}/users`);
    }
    
    // GET by ID
    getUser(id: number): Observable<User> {
        return this.http.get<User>(`${this.apiUrl}/users/${id}`);
    }
    
    // POST request
    createUser(user: User): Observable<User> {
        return this.http.post<User>(`${this.apiUrl}/users`, user);
    }
    
    // PUT request
    updateUser(id: number, user: User): Observable<User> {
        return this.http.put<User>(`${this.apiUrl}/users/${id}`, user);
    }
    
    // DELETE request
    deleteUser(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/users/${id}`);
    }
}

// Using service in component
export class UserListComponent implements OnInit {
    users: User[] = [];
    
    constructor(private dataService: DataService) {}
    
    ngOnInit() {
        this.dataService.getUsers().subscribe(
            (data) => {
                this.users = data;
            },
            (error) => {
                console.error('Error:', error);
            }
        );
    }
}
```

### Forms

```html
<!-- Template-driven form -->
<form (ngSubmit)="onSubmit()">
    <input [(ngModel)]="user.name" name="name" />
    <input [(ngModel)]="user.email" name="email" />
    <button type="submit">Submit</button>
</form>

<!-- Reactive form -->
<form [formGroup]="form" (ngSubmit)="onSubmit()">
    <input formControlName="name" />
    <input formControlName="email" />
    <button type="submit" [disabled]="!form.valid">Submit</button>
</form>
```

---

## 🔄 Common Workflows

### Spring Boot API Workflow

```
1. Create Entity (Database model)
       ↓
2. Create Repository (Data access)
       ↓
3. Create Service (Business logic)
       ↓
4. Create Controller (HTTP endpoints)
       ↓
5. Test endpoints (curl/Postman)
       ↓
6. Connect to Angular
```

### Angular Component Workflow

```
1. Define Interface/Model
       ↓
2. Create Service (HTTP calls)
       ↓
3. Create Component
       ↓
4. Inject Service in Component
       ↓
5. Call Service methods
       ↓
6. Display data in Template
       ↓
7. Handle user events
```

---

## 🐛 Common Issues & Fixes

| Issue | Solution |
|-------|----------|
| `Port already in use` | Change port in application.properties or kill process |
| `CORS error` | Add `@CrossOrigin` to Spring controller |
| `Module not found` | Run `npm install` or `mvn clean install` |
| `Connection refused` | Check if backend/database is running |
| `Import not working` | Check if dependency is in pom.xml/package.json |
| `undefined in template` | Check component property is initialized |

---

## 📚 Resources

- **Java**: https://docs.oracle.com/javase/tutorial/
- **Spring**: https://spring.io/docs
- **Angular**: https://angular.io/docs
- **TypeScript**: https://www.typescriptlang.org/docs/
- **MDN**: https://developer.mozilla.org/en-US/

---

**Keep this reference handy!** It covers 80% of what you'll need to know.
