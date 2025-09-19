package com.kclab.library.domain.exception;

import org.springframework.http.HttpStatus;

public class BookAlreadyExistException extends BusinessLogicException {

    private static final String DEFAULT_MESSAGE = "Book already exists.";

    public BookAlreadyExistException(String message) {
        super(
                BookAlreadyExistException.class.getSimpleName(),
                message,
                HttpStatus.CONFLICT.value()
        );
    }

    public BookAlreadyExistException() {
        this(DEFAULT_MESSAGE);
    }


}
