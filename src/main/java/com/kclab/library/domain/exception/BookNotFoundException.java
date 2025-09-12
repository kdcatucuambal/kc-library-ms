package com.kclab.library.domain.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String title) {
        super("Book with title '" + title + "' not found.");
    }
}
