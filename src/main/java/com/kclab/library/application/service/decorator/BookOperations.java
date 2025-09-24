package com.kclab.library.application.service.decorator;

import com.kclab.library.domain.model.Book;

interface BookOperations {
    // Operaciones básicas del libro
    String getId();
    String getTitle();
    String getAuthor();
    String getType();
    String getFormat();
    String getStatus();
    void setStatus(String status);

    Book getBook();
}
