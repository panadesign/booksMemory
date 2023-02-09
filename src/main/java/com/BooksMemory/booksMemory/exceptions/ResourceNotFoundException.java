package com.BooksMemory.booksMemory.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super("Resource not found");
    }
}
