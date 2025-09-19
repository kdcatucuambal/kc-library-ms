package com.kclab.library.application.service.strategy;

import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.FindBookRequest;
import com.kclab.library.shared.Constant;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component(Constant.FIND_ALL_BOOKS)
@RequiredArgsConstructor
@Setter
public class FindAll implements FindStrategy {

    private final BookRepositoryOutputPort bookRepository;

    @Override
    public List<Book> find(FindBookRequest request) {
        log.debug("Find all books by without filter: , request={}", request);
        return bookRepository.findAll();
    }

}
