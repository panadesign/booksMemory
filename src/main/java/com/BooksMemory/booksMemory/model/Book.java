package com.BooksMemory.booksMemory.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String authorLastname;
    private String authorFirstname;
    private String editor;

    public Book() {
    }

    public Book(Integer id, String title, String authorLastname, String authorFirstname, String editor) {
        this.id = id;
        this.title = title;
        this.authorLastname = authorLastname;
        this.authorFirstname = authorFirstname;
        this.editor = editor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Book update(Book book) {
        this.title = book.getTitle();
        this.authorLastname = book.getAuthorLastname();
        this.authorFirstname = book.getAuthorFirstname();
        this.editor = book.getEditor();
        return this;
    }
}
