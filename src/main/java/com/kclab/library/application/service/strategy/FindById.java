package com.kclab.library.application.service.strategy;

import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.FindBookRequest;
import com.kclab.library.shared.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(Constant.FIND_BOOK_BY_ID)
@RequiredArgsConstructor
public class FindById implements FindStrategy {

    private final BookRepositoryOutputPort bookRepository;

    @Override
    public List<Book> find(FindBookRequest request) {
        var book = bookRepository.findById(request.getValue());
        if (book == null) {
            return List.of();
        }
        return List.of(book);
    }
}
