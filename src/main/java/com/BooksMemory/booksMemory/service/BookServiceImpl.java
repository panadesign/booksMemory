package com.BooksMemory.booksMemory.service;

import com.BooksMemory.booksMemory.model.Book;
import com.BooksMemory.booksMemory.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Optional<Book> getBookByAuthorLastname(String authorLastname) {
        return bookRepository.findByAuthorLastname(authorLastname);
    }

    public Optional<Book> getBookByEditor(String editor) {
        return bookRepository.findByEditor(editor);
    }

    public Book addBook(Book book) {
       return bookRepository.save(book);
    }

}
