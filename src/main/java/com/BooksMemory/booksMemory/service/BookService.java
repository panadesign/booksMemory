package com.BooksMemory.booksMemory.service;

import com.BooksMemory.booksMemory.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBookList();
    Optional<Book> getBookById(Integer id);
    Optional<Book> getBookByTitle(String title);
    Optional<Book> getBookByAuthorLastname(String authorLastname);
    Optional<Book> getBookByEditor(String editor);
    Book addBook(Book book);
    void deleteBook(Integer id);

    Optional<Book> updateBook(Integer id, Book bookDto);
}
