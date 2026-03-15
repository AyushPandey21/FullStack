package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Find all completed todos
    List<Todo> findByCompleted(Boolean completed);

    // Find all todos by title (case-insensitive)
    List<Todo> findByTitleIgnoreCase(String title);

    // Find todos by title containing (partial search)
    List<Todo> findByTitleContainingIgnoreCase(String titlePart);

    // Custom query to find todo by exact title
    @Query("SELECT t FROM Todo t WHERE t.title = :title")
    Optional<Todo> findByExactTitle(@Param("title") String title);

    // Count todos by completion status
    long countByCompleted(Boolean completed);

    // Find all incomplete todos
    List<Todo> findByCompletedFalse();

    // Find all completed todos
    List<Todo> findByCompletedTrue();
}
