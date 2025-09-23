package com.kclab.library.application.service.decorator;

import com.kclab.library.domain.model.Book;

public abstract class BookDecorator implements BookOperations {
    protected BookOperations bookOperations;

    public BookDecorator(BookOperations bookOperations) {
        this.bookOperations = bookOperations;
    }

    @Override
    public String getId() {
        return bookOperations.getId();
    }

    @Override
    public String getTitle() {
        return bookOperations.getTitle();
    }

    @Override
    public String getAuthor() {
        return bookOperations.getAuthor();
    }

    @Override
    public String getType() {
        return bookOperations.getType();
    }

    @Override
    public String getFormat() {
        return bookOperations.getFormat();
    }

    @Override
    public String getStatus() {
        return bookOperations.getStatus();
    }

    @Override
    public Book getBook() {
        return bookOperations.getBook();
    }

    @Override
    public void setStatus(String status) {
        bookOperations.setStatus(status);
    }

    @Override
    public String getBookInfo() {
        return bookOperations.getBookInfo();
    }




}
