package com.kclab.library.application.service.validator;

import com.kclab.library.domain.model.Book;
import com.kclab.library.shared.lib.AbstractValidationHandler;
import com.kclab.library.shared.lib.ValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorBookValidator extends AbstractValidationHandler {
    private final static String VALIDATOR_NAME = "AuthorBookValidator";

    @Override
    public void validate(ValidatorContext context) {
        log.info("Start {}: {}", VALIDATOR_NAME, context);
        var book = context.getValue("book", Book.class);
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author is required");
        }
        validateNext(context);
    }
}
