package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // GET /api/todos - Get all todos
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    // GET /api/todos/{id} - Get a specific todo by ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Todo> todo = todoRepository.findById(id);
        
        if (todo.isPresent()) {
            return ResponseEntity.ok(todo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/todos - Create a new todo
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        // Set timestamps
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        
        // Save to database
        Todo savedTodo = todoRepository.save(todo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    // PUT /api/todos/{id} - Update an existing todo
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        
        if (todoOptional.isPresent()) {
            Todo existingTodo = todoOptional.get();
            
            // Update fields
            existingTodo.setTitle(todoDetails.getTitle());
            existingTodo.setDescription(todoDetails.getDescription());
            existingTodo.setCompleted(todoDetails.getCompleted());
            existingTodo.setUpdatedAt(LocalDateTime.now());
            
            // Save updated todo
            Todo updatedTodo = todoRepository.save(existingTodo);
            
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/todos/{id} - Delete a todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        
        if (todo.isPresent()) {
            todoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /api/todos/completed - Get all completed todos
    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getCompletedTodos() {
        List<Todo> completedTodos = todoRepository.findByCompletedTrue();
        return ResponseEntity.ok(completedTodos);
    }

    // GET /api/todos/incomplete - Get all incomplete todos
    @GetMapping("/incomplete")
    public ResponseEntity<List<Todo>> getIncompleteTodos() {
        List<Todo> incompleteTodos = todoRepository.findByCompletedFalse();
        return ResponseEntity.ok(incompleteTodos);
    }

    // GET /api/todos/search?title=keyword - Search todos by title
    @GetMapping("/search")
    public ResponseEntity<List<Todo>> searchTodosByTitle(@RequestParam String title) {
        List<Todo> todos = todoRepository.findByTitleContainingIgnoreCase(title);
        return ResponseEntity.ok(todos);
    }

    // GET /api/todos/count - Get total count of todos
    @GetMapping("/count")
    public ResponseEntity<Long> getTodoCount() {
        long count = todoRepository.count();
        return ResponseEntity.ok(count);
    }

    // PATCH /api/todos/{id}/toggle - Toggle completed status
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Todo> toggleTodoCompletion(@PathVariable Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setCompleted(!todo.getCompleted());
            todo.setUpdatedAt(LocalDateTime.now());
            
            Todo updatedTodo = todoRepository.save(todo);
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
