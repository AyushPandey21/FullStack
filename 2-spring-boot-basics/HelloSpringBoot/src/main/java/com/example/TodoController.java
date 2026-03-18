package com.example;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // GET /api/todos - Get all todos
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    // GET /api/todos?id=10 - Get a specific todo by query parameter ID
    @GetMapping(params = "id")
    public ResponseEntity<Todo> getTodoByIdQuery(@RequestParam Long id) {
        Todo todo = todoService.getTodoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return ResponseEntity.ok(todo);
    }

    // GET /api/todos/{id} - Get a specific todo by ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return ResponseEntity.ok(todo);
    }

    // POST /api/todos - Create a new todo
    @PostMapping
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    // PUT /api/todos/{id} - Update an existing todo
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @Valid @RequestBody Todo todoDetails) {
        Todo updated = todoService.updateTodo(id, todoDetails)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/todos/{id} - Delete a todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        if (!todoService.deleteTodo(id)) {
            throw new ResourceNotFoundException("Todo not found with id: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    // GET /api/todos/completed - Get all completed todos
    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getCompletedTodos() {
        List<Todo> completedTodos = todoService.getCompletedTodos();
        return ResponseEntity.ok(completedTodos);
    }

    // GET /api/todos/incomplete - Get all incomplete todos
    @GetMapping("/incomplete")
    public ResponseEntity<List<Todo>> getIncompleteTodos() {
        List<Todo> incompleteTodos = todoService.getIncompleteTodos();
        return ResponseEntity.ok(incompleteTodos);
    }

    // GET /api/todos/search?title=keyword - Search todos by title
    @GetMapping("/search")
    public ResponseEntity<List<Todo>> searchTodosByTitle(@RequestParam String title) {
        List<Todo> todos = todoService.searchTodosByTitle(title);
        return ResponseEntity.ok(todos);
    }

    // GET /api/todos/count - Get total count of todos
    @GetMapping("/count")
    public ResponseEntity<Long> getTodoCount() {
        long count = todoService.getTodoCount();
        return ResponseEntity.ok(count);
    }

    // PATCH /api/todos/{id}/toggle - Toggle completed status
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Todo> toggleTodoCompletion(@PathVariable Long id) {
        Todo toggled = todoService.toggleTodoCompletion(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return ResponseEntity.ok(toggled);
    }
}
