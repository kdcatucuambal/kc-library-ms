package com.kclab.library.domain.exception;

import org.springframework.http.HttpStatus;

public class InvalidBookException extends BusinessLogicException {

    private static final String DEFAULT_MESSAGE = "Invalid book data";

    public InvalidBookException(String message) {
        super(InvalidBookException.class.getSimpleName(),
                message,
                HttpStatus.BAD_REQUEST.value()
        );
    }

    public InvalidBookException() {
        this(DEFAULT_MESSAGE);
    }
}
