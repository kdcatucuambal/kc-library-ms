package com.kclab.library.application.service;

import com.kclab.library.application.input.port.QueryBookInputPort;
import com.kclab.library.application.service.strategy.FindStrategy;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.FindBookRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QueryBookService implements QueryBookInputPort {

    private final Map<String, FindStrategy> findStrategies;

    @Override
    public Book findByTitle(String title) {
        return findStrategies.get("findByTitle").find(buildRequest(title)).getFirst();
    }

    @Override
    public List<Book> findAll() {
        return findStrategies.get("findByAll").find(buildRequest(StringUtils.EMPTY));
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return findStrategies.get("findByAuthor").find(buildRequest(author));
    }


    private static FindBookRequest buildRequest(String value) {
        return FindBookRequest.builder()
                .value(value)
                .build();
    }

}
