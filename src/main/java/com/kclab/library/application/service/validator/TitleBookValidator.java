package com.kclab.library.application.service.validator;

import com.kclab.library.application.input.port.QueryBookInputPort;
import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.model.Book;
import com.kclab.library.shared.lib.AbstractValidationHandler;
import com.kclab.library.shared.lib.ValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TitleBookValidator extends AbstractValidationHandler {

    private final static String VALIDATOR_NAME = "TitleBookValidator";
    private final BookRepositoryOutputPort bookRepository;

    @Override
    public void validate(ValidatorContext context) {
        log.info("Executing {}...", VALIDATOR_NAME);
        var book = context.getValue("book", Book.class);
        validateBook(book);
        validateIfBookExists(book.getTitle());
        validateNext(context);
    }

    private void validateBook(Book book) {
        if (book == null || book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Book title must not be null or empty.");
        }
    }


    private void validateIfBookExists(String title) {
        if (bookRepository.findByTitle(title).isPresent()) {
            throw new IllegalArgumentException("Book with title '" + title + "' already exists.");
        }
    }


}
