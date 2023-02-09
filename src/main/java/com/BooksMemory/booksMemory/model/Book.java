package com.BooksMemory.booksMemory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String authorLastname;
    private String authorFirstname;
    private String editor;

    public Book update(Book book) {
        this.title = book.getTitle();
        this.authorLastname = book.getAuthorLastname();
        this.authorFirstname = book.getAuthorFirstname();
        this.editor = book.getEditor();
        return this;
    }
}
