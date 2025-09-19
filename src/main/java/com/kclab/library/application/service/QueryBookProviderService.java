package com.kclab.library.application.service;

import com.kclab.library.application.input.port.QueryBookInputPort;
import com.kclab.library.application.input.port.QueryBookProviderInputPort;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.QueryBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryBookProviderService implements QueryBookProviderInputPort {

    private final QueryBookInputPort queryBookInputPort;

    @Override
    public List<Book> getBooks(QueryBookRequest request) {
        if (request.getTitle() != null && !request.getTitle().isEmpty()) {
            return queryBookInputPort.findByTitle(request.getTitle());
        } else if (request.getAuthor() != null && !request.getAuthor().isEmpty()) {
            return queryBookInputPort.findByAuthor(request.getAuthor());
        } else {
            return queryBookInputPort.findAll();
        }
    }


}
