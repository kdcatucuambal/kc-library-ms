package com.kclab.library.domain.exception;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends BusinessLogicException {
    private static final String DEFAULT_MESSAGE = "Book not found";

    public BookNotFoundException(String message) {
        super(
                BookNotFoundException.class.getSimpleName(),
                message,
                HttpStatus.NOT_FOUND.value()
        );
    }

    public BookNotFoundException() {
        this(DEFAULT_MESSAGE);
    }
}
