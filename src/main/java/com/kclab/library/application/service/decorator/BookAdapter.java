package com.kclab.library.application.service.decorator;

import com.kclab.library.domain.model.Book;

public class BookAdapter implements BookOperations {
    private Book book;

    public BookAdapter(Book book) {
        this.book = book;
    }

    @Override
    public String getId() {
        return book.getId();
    }

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public String getAuthor() {
        return book.getAuthor();
    }

    @Override
    public String getType() {
        return book.getType();
    }

    @Override
    public String getFormat() {
        return book.getFormat();
    }

    @Override
    public String getStatus() {
        return book.getStatus();
    }

    @Override
    public void setStatus(String status) {
        book.setStatus(status);
    }

    @Override
    public String getBookInfo() {
        return book.toString();
    }

    @Override
    public Book getBook() {
        return book;
    }
}