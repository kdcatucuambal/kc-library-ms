package com.kclab.library.application.service.strategy;


import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.FindBookRequest;
import com.kclab.library.shared.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(Constant.FIND_BOOK_BY_AUTHOR)
@RequiredArgsConstructor
public class FindByAuthor implements FindStrategy {
    private final BookRepositoryOutputPort bookRepository;

    @Override
    public List<Book> find(FindBookRequest request) {
        return bookRepository.findByAuthor(request.getValue());
    }
}
