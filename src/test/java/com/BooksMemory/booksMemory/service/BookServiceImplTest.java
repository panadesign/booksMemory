package com.BooksMemory.booksMemory.service;

import com.BooksMemory.booksMemory.model.Book;
import com.BooksMemory.booksMemory.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BookServiceImplTest {

    private BookServiceImpl bookServiceImpl;

    @Mock
    private BookRepository mockBookRepository;

    @BeforeEach
    void init() {
        bookServiceImpl = new BookServiceImpl(mockBookRepository);
    }

    @Test
    void getBookList() {
        //GIVEN
        List<Book> bookList = new ArrayList<>();

        Book book1 = new Book(1, "Livre1", "Auteur1", "Editeur1");
        Book book2 = new Book(2, "Livre2", "Auteur2", "Editeur2");

        bookList.add(book1);
        bookList.add(book2);

        //WHEN
        when(mockBookRepository.findAll()).thenReturn(bookList);
        List<Book> books = bookServiceImpl.getBookList();

        //THEN
        Assertions.assertEquals(2, books.size());
        Assertions.assertTrue(books.contains(book1));
    }

    @Test
    void getBookById() {
        //GIVEN
        Book book1 = new Book(1, "Livre1", "Auteur1", "Editeur1");

        when(mockBookRepository.findById(1)).thenReturn(Optional.of(book1));
        Optional<Book> book = bookServiceImpl.getBookById(1);

        //THEN
        assertThat(book)
                .isNotEmpty()
                .get()
                .satisfies(p -> assertThat(p.getTitle()).isEqualTo(book1.getTitle()));
    }
}