package com.BooksMemory.booksMemory.service;

import com.BooksMemory.booksMemory.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBookList();
    Optional<Book> getBookById(Integer id);
}
