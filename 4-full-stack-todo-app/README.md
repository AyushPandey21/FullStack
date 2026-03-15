# Level 4: Full Stack Todo App

Congratulations! Now you'll build your first complete full stack application with Angular frontend and Spring Boot backend.

## 🎯 Project Overview

We'll build a **Todo Application** where users can:
- ✅ View all todos
- ✅ Add new todos
- ✅ Mark todos as complete
- ✅ Delete todos
- ✅ Update todo description

**Frontend**: Angular
**Backend**: Spring Boot REST API
**Database**: PostgreSQL

## 📂 Project Structure

```
4-full-stack-todo-app/
├── README.md (this file)
├── TodoBackend/          # Spring Boot REST API
│   ├── pom.xml
│   ├── src/
│   │   ├── main/java/com/example/
│   │   │   ├── TodoApplication.java
│   │   │   ├── model/
│   │   │   │   └── Todo.java
│   │   │   ├── controller/
│   │   │   │   └── TodoController.java
│   │   │   ├── repository/
│   │   │   │   └── TodoRepository.java
│   │   │   └── service/
│   │   │       └── TodoService.java
│   │   └── resources/
│   │       └── application.properties
│   └── README.md (backend setup)
│
├── TodoFrontend/         # Angular Application
│   ├── angular.json
│   ├── src/
│   │   ├── app/
│   │   │   ├── models/
│   │   │   │   └── todo.model.ts
│   │   │   ├── services/
│   │   │   │   └── todo.service.ts
│   │   │   ├── components/
│   │   │   │   ├── todo-list/
│   │   │   │   ├── add-todo/
│   │   │   │   └── todo-item/
│   │   │   ├── app.component.html
│   │   │   └── app.component.ts
│   │   └── main.ts
│   └── README.md (frontend setup)
│
└── deployment/           # Docker & deployment
    ├── docker-compose.yml
    └── README.md
```

## 🎯 Learning Outcomes

By the end of this project, you'll know:
- ✅ How to structure a full stack application
- ✅ Build data models and repositories
- ✅ Create REST services
- ✅ Communicate between frontend and backend
- ✅ Handle CORS (Cross-Origin Resource Sharing)
- ✅ Complete CRUD workflow
- ✅ Basic error handling

## 📋 Backend Setup (Spring Boot)

### Step 1: Create Spring Boot Project

```bash
# Create parent directory
mkdir TodoBackend
cd TodoBackend

# Generate Spring Boot project
mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=todo-backend \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

### Step 2: Configure pom.xml

Add these dependencies:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.2.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>3.2.0</version>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.0</version>
    </dependency>
</dependencies>
```

### Step 3: Create Entity (Todo.java)

```java
package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    private String description;
    
    @Column(nullable = false)
    private boolean completed = false;
    
    @Column(name = "created_at")
    private Long createdAt;
    
    // Constructors
    public Todo() {}
    
    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.createdAt = System.currentTimeMillis();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    public Long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
```

### Step 4: Create Repository (TodoRepository.java)

```java
package com.example.repository;

import com.example.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
```

### Step 5: Create Controller (TodoController.java)

```java
package com.example.controller;

import com.example.model.Todo;
import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
    
    @Autowired
    private TodoRepository todoRepository;
    
    // GET all todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    
    // GET todo by ID
    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable Long id) {
        return todoRepository.findById(id);
    }
    
    // CREATE new todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setCreatedAt(System.currentTimeMillis());
        return todoRepository.save(todo);
    }
    
    // UPDATE todo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Optional<Todo> existingTodo = todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            Todo todo = existingTodo.get();
            if (todoDetails.getTitle() != null) {
                todo.setTitle(todoDetails.getTitle());
            }
            if (todoDetails.getDescription() != null) {
                todo.setDescription(todoDetails.getDescription());
            }
            todo.setCompleted(todoDetails.isCompleted());
            return todoRepository.save(todo);
        }
        return null;
    }
    
    // DELETE todo
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
```

### Step 6: Configure application.properties

Create `src/main/resources/application.properties`:

```properties
# Server
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL10Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Step 7: Create Main Application

```java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }
}
```

### Step 8: Run Backend

```bash
mvn spring-boot:run
```

Test endpoint:
```bash
curl http://localhost:8080/api/todos
```

---

## 🎨 Frontend Setup (Angular)

### Step 1: Create Angular Project

```bash
ng new TodoFrontend
cd TodoFrontend
```

### Step 2: Create Models (todo.model.ts)

```typescript
export interface Todo {
    id?: number;
    title: string;
    description?: string;
    completed: boolean;
    createdAt?: number;
}
```

### Step 3: Create Service (todo.service.ts)

```typescript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from '../models/todo.model';

@Injectable({
    providedIn: 'root'
})
export class TodoService {
    private apiUrl = 'http://localhost:8080/api/todos';
    
    constructor(private http: HttpClient) {}
    
    getAllTodos(): Observable<Todo[]> {
        return this.http.get<Todo[]>(this.apiUrl);
    }
    
    getTodoById(id: number): Observable<Todo> {
        return this.http.get<Todo>(`${this.apiUrl}/${id}`);
    }
    
    createTodo(todo: Todo): Observable<Todo> {
        return this.http.post<Todo>(this.apiUrl, todo);
    }
    
    updateTodo(id: number, todo: Todo): Observable<Todo> {
        return this.http.put<Todo>(`${this.apiUrl}/${id}`, todo);
    }
    
    deleteTodo(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
```

### Step 4: Create Main Component

```typescript
import { Component, OnInit } from '@angular/core';
import { TodoService } from './services/todo.service';
import { Todo } from './models/todo.model';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    todos: Todo[] = [];
    newTodoTitle: string = '';
    
    constructor(private todoService: TodoService) {}
    
    ngOnInit() {
        this.loadTodos();
    }
    
    loadTodos() {
        this.todoService.getAllTodos().subscribe(
            (data) => {
                this.todos = data;
            },
            (error) => {
                console.error('Error loading todos:', error);
            }
        );
    }
    
    addTodo() {
        if (this.newTodoTitle.trim()) {
            const todo: Todo = {
                title: this.newTodoTitle,
                description: '',
                completed: false
            };
            this.todoService.createTodo(todo).subscribe(
                (createdTodo) => {
                    this.todos.push(createdTodo);
                    this.newTodoTitle = '';
                }
            );
        }
    }
    
    toggleTodo(todo: Todo) {
        todo.completed = !todo.completed;
        this.todoService.updateTodo(todo.id!, todo).subscribe();
    }
    
    deleteTodo(id: number) {
        this.todoService.deleteTodo(id).subscribe(
            () => {
                this.todos = this.todos.filter(t => t.id !== id);
            }
        );
    }
}
```

### Step 5: Create Template (app.component.html)

```html
<div class="container">
    <h1>📝 Todo Application</h1>
    
    <div class="add-todo">
        <input 
            [(ngModel)]="newTodoTitle" 
            placeholder="Add new todo..."
            (keyup.enter)="addTodo()"
        />
        <button (click)="addTodo()">Add</button>
    </div>
    
    <div class="todo-list">
        <div *ngFor="let todo of todos" class="todo-item">
            <input 
                type="checkbox" 
                [checked]="todo.completed"
                (change)="toggleTodo(todo)"
            />
            <span [class.completed]="todo.completed">{{ todo.title }}</span>
            <button class="delete" (click)="deleteTodo(todo.id!)">Delete</button>
        </div>
    </div>
</div>
```

### Step 6: Add Styles (app.component.css)

```css
.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    font-family: Arial, sans-serif;
}

h1 {
    color: #333;
    text-align: center;
}

.add-todo {
    display: flex;
    gap: 10px;
    margin: 20px 0;
}

.add-todo input {
    flex: 1;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
}

.add-todo button {
    padding: 10px 20px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.add-todo button:hover {
    background-color: #45a049;
}

.todo-list {
    list-style: none;
    padding: 0;
}

.todo-item {
    display: flex;
    align-items: center;
    gap: 10px;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    margin-bottom: 10px;
    background-color: #f9f9f9;
}

.todo-item input[type="checkbox"] {
    width: 20px;
    height: 20px;
    cursor: pointer;
}

.todo-item span {
    flex: 1;
}

.todo-item span.completed {
    text-decoration: line-through;
    color: #999;
}

.delete {
    padding: 5px 10px;
    background-color: #f44336;
    color: white;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    font-size: 12px;
}

.delete:hover {
    background-color: #da190b;
}
```

### Step 7: Import Required Modules (app.module.ts)

```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

@NgModule({
    declarations: [AppComponent],
    imports: [BrowserModule, HttpClientModule, FormsModule],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {}
```

### Step 8: Run Frontend

```bash
ng serve
```

Visit: http://localhost:4200

---

## 🚀 Running the Full Stack Application

### Terminal 1: PostgreSQL (ensure running)

```bash
# PostgreSQL should be running as a service
```

### Terminal 2: Spring Boot Backend

```bash
cd TodoBackend
mvn spring-boot:run
```

### Terminal 3: Angular Frontend

```bash
cd TodoFrontend
ng serve
```

Visit http://localhost:4200 - Your todo app is live! 🎉

---

## ✅ Full Stack Checklist

- [ ] Backend API running on port 8080
- [ ] Frontend running on port 4200
- [ ] Can add new todos
- [ ] Can view all todos
- [ ] Can mark todos complete
- [ ] Can delete todos
- [ ] Frontend communicates with backend
- [ ] No CORS errors

---

## 🔗 Next Steps

After mastering this project:
1. [Level 5: Advanced Backend](../5-advanced-backend/README.md) - Authentication, advanced queries
2. [Level 6: Advanced Frontend](../6-advanced-frontend/README.md) - Routing, services, RxJS
3. [Level 7: Production](../7-production-deployment/README.md) - Docker, CI/CD, deployment

---

## 💡 Tips

- **Test frequently**: Use Postman/curl for API testing
- **Check browser console**: For Angular errors
- **Check server logs**: For backend errors
- **Use ng serve --poll**: If live reload doesn't work
- **Check CORS**: If frontend can't call backend

---

**Congratulations!** You've built your first full stack application! 🎊
