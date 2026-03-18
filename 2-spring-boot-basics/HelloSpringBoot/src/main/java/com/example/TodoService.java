package com.example;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    public Optional<Todo> updateTodo(Long id, Todo todoDetails) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTitle(todoDetails.getTitle());
                    existingTodo.setDescription(todoDetails.getDescription());
                    existingTodo.setCompleted(todoDetails.getCompleted());
                    existingTodo.setUpdatedAt(LocalDateTime.now());
                    return todoRepository.save(existingTodo);
                });
    }

    public boolean deleteTodo(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Todo> getCompletedTodos() {
        return todoRepository.findByCompletedTrue();
    }

    public List<Todo> getIncompleteTodos() {
        return todoRepository.findByCompletedFalse();
    }

    public List<Todo> searchTodosByTitle(String title) {
        return todoRepository.findByTitleContainingIgnoreCase(title);
    }

    public long getTodoCount() {
        return todoRepository.count();
    }

    public Optional<Todo> toggleTodoCompletion(Long id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setCompleted(!todo.getCompleted());
                    todo.setUpdatedAt(LocalDateTime.now());
                    return todoRepository.save(todo);
                });
    }
}
