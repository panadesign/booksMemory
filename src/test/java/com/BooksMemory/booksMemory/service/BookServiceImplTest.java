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

        Book book1 = new Book(1, "Livre1", "Lastname1", "Firstname1", "Editeur1");
        Book book2 = new Book(2, "Livre2", "Lastname2", "Firstname2", "Editeur2");

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
        Book book1 = new Book(1, "Livre1", "Lastname1", "Firstname1", "Editeur1");

        //WHEN
        when(mockBookRepository.findById(book1.getId())).thenReturn(Optional.of(book1));
        Optional<Book> book = bookServiceImpl.getBookById(1);

        //THEN
        assertThat(book)
                .isNotEmpty()
                .get()
                .satisfies(p -> assertThat(p.getTitle()).isEqualTo(book1.getTitle()));
    }

    @Test
    void getBookByTitle() {
        //GIVEN
        Book book1 = new Book(1, "Livre1", "Lastname1", "Firstname1", "Editeur1");

        //WHEN
        when(mockBookRepository.findByTitle(book1.getTitle())).thenReturn(Optional.of(book1));
        Optional<Book> book = bookServiceImpl.getBookByTitle(book1.getTitle());

        //THEN
        assertThat(book)
                .isNotEmpty()
                .get()
                .satisfies(p -> assertThat(p.getTitle()).isEqualTo(book1.getTitle()));
    }

    @Test
    void getBookByAuthorLastname() {
        //GIVEN
        Book book1 = new Book(1, "Livre1", "Lastname1", "Firstname1", "Editeur1");

        //WHEN
        when(mockBookRepository.findByAuthorLastname(book1.getAuthorLastname())).thenReturn(Optional.of(book1));
        Optional<Book> book = bookServiceImpl.getBookByAuthorLastname(book1.getAuthorLastname());

        //THEN
        assertThat(book)
                .isNotEmpty()
                .get()
                .satisfies(p -> assertThat(p.getAuthorLastname()).isEqualTo(book1.getAuthorLastname()));
    }

    @Test
    void getBookByEditor() {
        //GIVEN
        Book book1 = new Book(1, "Livre1", "Lastname1", "Firstname1", "Editeur1");

        //WHEN
        when(mockBookRepository.findByEditor(book1.getEditor())).thenReturn(Optional.of(book1));
        Optional<Book> book = bookServiceImpl.getBookByEditor(book1.getEditor());

        //THEN
        assertThat(book)
                .isNotEmpty()
                .get()
                .satisfies(p -> assertThat(p.getEditor()).isEqualTo(book1.getEditor()));
    }

    @Test
    void addBook() {
        //GIVEN
        List<Book> books = new ArrayList<>();
        Book book1 = new Book(1, "Livre1", "Lastname1", "Firstname1", "Editeur1");
        books.add(book1);

        //WHEN
        when(mockBookRepository.findAll()).thenReturn(books);
        when(mockBookRepository.save(book1)).thenReturn(book1);

        Book bookAdded = bookServiceImpl.addBook(book1);

        //THEN
        Assertions.assertTrue(books.contains(bookAdded));
    }

    @Test
    void deleteBook() {
        //GIVEN
        Book book1 = new Book(1, "Livre1", "Lastname1", "Firstname1", "Editeur1");

        //WHEN
        when(mockBookRepository.findById(book1.getId())).thenReturn(Optional.of(book1));
        bookServiceImpl.deleteBook(book1.getId());

        //THEN
        assertThat(mockBookRepository.count()).isEqualTo(0);
    }
}