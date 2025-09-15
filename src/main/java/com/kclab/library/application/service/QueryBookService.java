package com.kclab.library.application.service;

import com.kclab.library.application.input.port.QueryBookInputPort;
import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.exception.BookNotFoundException;
import com.kclab.library.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryBookService implements QueryBookInputPort {

    private final BookRepositoryOutputPort bookRepository;


    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title).orElseThrow(() -> new BookNotFoundException(title));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
}
