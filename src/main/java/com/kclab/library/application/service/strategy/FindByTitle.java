package com.kclab.library.application.service.strategy;

import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("findByTitle")
@RequiredArgsConstructor
public class FindByTitle implements FindStrategy {

    private final BookRepositoryOutputPort bookRepository;

    @Override
    public List<Book> find(String query) {
        return bookRepository.findByTitle(query).map(List::of).orElse(List.of());
    }
}
