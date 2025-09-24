package com.kclab.library.application.output.port;

import com.kclab.library.domain.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepositoryOutputPort {

    Book save(Book book);
    Optional<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findAll();
    Book findById(String id);
    void updateStatus(Book book);

}
