package com.BooksMemory.booksMemory.controllers;

import com.BooksMemory.booksMemory.model.Book;
import com.BooksMemory.booksMemory.repository.BookRepository;
import com.BooksMemory.booksMemory.service.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Slf4j
public class BookController {
    private final BookServiceImpl bookService;


    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/library/books")
    public String bookList(Model model) {
        List<Book> allBooks = bookService.getBookList();
        model.addAttribute("book", allBooks);
        log.info("Get all books");
        return "book/books";
    }
}
