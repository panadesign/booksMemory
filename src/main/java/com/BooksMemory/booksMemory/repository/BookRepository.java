package com.BooksMemory.booksMemory.repository;

import com.BooksMemory.booksMemory.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthorLastname(String authorLastname);
    Optional<Book> findByEditor(String editor);
}
