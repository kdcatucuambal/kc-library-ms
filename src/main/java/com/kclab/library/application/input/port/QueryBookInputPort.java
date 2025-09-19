package com.kclab.library.application.input.port;

import com.kclab.library.domain.model.Book;

import java.util.List;

public interface QueryBookInputPort {

    List<Book> findByTitle(String title);
    List<Book> findAll();
    List<Book> findByAuthor(String author);


}
