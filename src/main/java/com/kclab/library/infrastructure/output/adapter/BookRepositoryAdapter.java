package com.kclab.library.infrastructure.output.adapter;

import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.model.Book;
import com.kclab.library.infrastructure.output.repository.BookJPARepository;
import com.kclab.library.infrastructure.output.repository.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepositoryOutputPort {

    private final BookJPARepository bookJPARepository;
    private final BookMapper mapper;

    @Override
    public Book save(Book book) {
        return mapper.toDomain(bookJPARepository.save(mapper.toEntity(book)));
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookJPARepository.findByTitle(title).map(mapper::toDomain);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookJPARepository.findByAuthor(author).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Book> findAll() {
        return bookJPARepository.findAll().stream().map(mapper::toDomain).toList();
    }
}
