package com.kclab.library.infrastructure.input.adapter.rest.impl;

import com.kclab.library.application.input.port.CreateBookInputPort;
import com.kclab.library.application.input.port.LendableBookServiceInputPort;
import com.kclab.library.application.input.port.QueryBookProviderInputPort;
import com.kclab.library.domain.enums.BookFormat;
import com.kclab.library.domain.enums.BookType;
import com.kclab.library.domain.model.QueryBookRequest;

import com.kclab.services.server.ApiApi;
import com.kclab.services.server.models.Book;
import com.kclab.services.server.models.BookUpdate;
import com.kclab.services.server.models.CreateBookRq;
import com.kclab.services.server.models.CreateBookRs;
import com.kclab.services.server.models.LegacyBook;
import com.kclab.services.server.models.LoanRequest;
import com.kclab.services.server.models.Observer;
import com.kclab.services.server.models.ObserverCreate;
import com.kclab.services.server.models.QueryBooksRs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController implements ApiApi {

    private final CreateBookInputPort createBookInputPort;
    private final QueryBookProviderInputPort queryBookProviderInputPort;
    private final LendableBookServiceInputPort lendableBookServiceInputPort;

    @Override
    public ResponseEntity<QueryBooksRs> apiBooksGet(String title, String author, Integer page, Integer size) {
        var queryBookRequest = QueryBookRequest
                .builder()
                .author(author)
                .title(title)
                .build();
        var books = queryBookProviderInputPort.getBooks(queryBookRequest).stream().map(book ->{
            var b = new Book();
            b.setId(UUID.fromString(book.getId()));
            b.setAuthor(book.getAuthor());
            b.setFormat(Book.FormatEnum.fromValue(book.getFormat()));
            b.setType(Book.TypeEnum.fromValue(book.getType()));
            b.setTitle(book.getTitle());
            b.setStatus(Book.StatusEnum.fromValue(book.getStatus()));
            return b;
        });
        return ResponseEntity.ok(new QueryBooksRs().books(books.toList()));
    }

    @Override
    public ResponseEntity<Book> apiBooksIdGet(String id) {
        return null;
    }

    @Override
    public ResponseEntity<com.kclab.services.server.models.LendResponse> apiBooksIdLendPost(String id, LoanRequest loanRequest) {
        var lent = lendableBookServiceInputPort.execute(id, loanRequest.getBorrower());
        var res = new com.kclab.services.server.models.LendResponse();
        res.setWasLent(lent);
        return ResponseEntity
                .created(URI.create("/books/" + id))
                .body(res);

    }

    @Override
    public ResponseEntity<Book> apiBooksIdPut(String id, BookUpdate bookUpdate) {
        return null;
    }

    @Override
    public ResponseEntity<CreateBookRs> apiBooksPost(CreateBookRq createBookRq) {
                var book = createBookRq.getBook();
        var createBookDto = com.kclab.library.domain.model.CreateBookDTO
                .builder()
                .author(book.getAuthor())
                .format(BookFormat.fromValue(book.getFormat().getValue()))
                .type(BookType.fromValue(book.getType().getValue()))
                .title(book.getTitle())
                .build();
        var bookCreated = createBookInputPort.execute(createBookDto);
        book.setId(UUID.fromString(bookCreated.getId()));
        var createBookRs = new CreateBookRs();
        createBookRs.setBook(book);
        return ResponseEntity.ok(createBookRs);
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







//    @Override
//    public ResponseEntity<BookList> apiBooksGet(String title, String author, String strategy, Integer page, Integer size) {
//        queryBookProviderInputPort.getBooks(
//                QueryBookRequest
//                        .builder()
//                        .author(author)
//                        .title(title)
//                        .build()
//        );
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Book> apiBooksIdGet(String id) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Book> apiBooksIdLendPost(String id, LoanRequest loanRequest) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Book> apiBooksIdPut(String id, BookUpdate bookUpdate) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Book> apiBooksPost(BookCreate bookCreate) {
//        var bookCreated = createBookInputPort.execute(
//                com.kclab.library.domain.model.Book
//                        .builder()
//                        .author(bookCreate.getAuthor())
//                        .format(bookCreate.getFormat().getValue())
//                        .type(bookCreate.getType().getValue())
//                        .title(bookCreate.getTitle())
//                        .status("A")
//                        .build()
//        );
//
//        return ResponseEntity.ok(
//                new Book()
//                        .id(UUID.fromString(bookCreated.getId()))
//                        .author(bookCreated.getAuthor())
//                        .format(Book.FormatEnum.fromValue(bookCreated.getFormat()))
//                        .type(Book.TypeEnum.fromValue(bookCreated.getType()))
//                        .title(bookCreated.getTitle())
//                        .status(Book.StatusEnum.fromValue(bookCreated.getStatus()))
//        );
//    }
//
//    @Override
//    public ResponseEntity<Book> apiLegacyBooksPost(LegacyBook legacyBook) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<List<Observer>> apiObserversGet() {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<Observer> apiObserversPost(ObserverCreate observerCreate) {
//        return null;
//    }

}
