package com.kclab.library.infrastructure.input.adapter.rest.impl;

import com.kclab.library.application.input.port.CreateBookInputPort;
import com.kclab.library.application.input.port.QueryBookInputPort;
import com.kclab.library.application.input.port.QueryBookProviderInputPort;
import com.kclab.library.domain.model.QueryBookRequest;
import com.kclab.services.server.ApiApi;
import com.kclab.services.server.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController implements ApiApi {

    private final CreateBookInputPort createBookInputPort;
    private final QueryBookProviderInputPort queryBookProviderInputPort;


    @Override
    public ResponseEntity<BookList> apiBooksGet(String title, String author, String strategy, Integer page, Integer size) {
        queryBookProviderInputPort.getBooks(
                QueryBookRequest
                        .builder()
                        .author(author)
                        .title(title)
                        .build()
        );
        return null;
    }

    @Override
    public ResponseEntity<Book> apiBooksIdGet(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Book> apiBooksIdLendPost(String id, LoanRequest loanRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Book> apiBooksIdPut(String id, BookUpdate bookUpdate) {
        return null;
    }

    @Override
    public ResponseEntity<Book> apiBooksPost(BookCreate bookCreate) {
        var bookCreated = createBookInputPort.execute(
                com.kclab.library.domain.model.Book
                        .builder()
                        .author(bookCreate.getAuthor())
                        .format(bookCreate.getFormat().getValue())
                        .type(bookCreate.getType().getValue())
                        .title(bookCreate.getTitle())
                        .status("A")
                        .build()
        );

        return ResponseEntity.ok(
                new Book()
                        .id(UUID.fromString(bookCreated.getId()))
                        .author(bookCreated.getAuthor())
                        .format(Book.FormatEnum.fromValue(bookCreated.getFormat()))
                        .type(Book.TypeEnum.fromValue(bookCreated.getType()))
                        .title(bookCreated.getTitle())
                        .status(Book.StatusEnum.fromValue(bookCreated.getStatus()))
        );
    }

    @Override
    public ResponseEntity<Book> apiLegacyBooksPost(LegacyBook legacyBook) {
        return null;
    }

    @Override
    public ResponseEntity<List<Observer>> apiObserversGet() {
        return null;
    }

    @Override
    public ResponseEntity<Observer> apiObserversPost(ObserverCreate observerCreate) {
        return null;
    }

}
