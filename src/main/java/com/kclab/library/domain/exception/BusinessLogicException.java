package com.kclab.library.domain.exception;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {

    private final String exceptionType;
    private final String message;
    private final int httpStatus;


    public BusinessLogicException(String exceptionType, String message, int httpStatus) {
        super(message);
        this.exceptionType = exceptionType;
        this.message = message;
        this.httpStatus = httpStatus;
    }


}
