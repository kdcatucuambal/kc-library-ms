package com.kclab.library.application.service;

import com.kclab.library.application.input.port.CreateBookInputPort;
import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.application.service.factory.BookFactoryProvider;
import com.kclab.library.application.service.validator.AuthorBookValidator;
import com.kclab.library.application.service.validator.TitleBookValidator;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.CreateBookDTO;
import com.kclab.library.shared.lib.ValidatorContext;
import com.kclab.library.shared.lib.ValidatorExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateBookService implements CreateBookInputPort {

    private final BookRepositoryOutputPort bookRepository;
    private final TitleBookValidator titleBookValidator;
    private final AuthorBookValidator authorBookValidator;

    @Override
    public Book execute(CreateBookDTO bookDTO) {
        var book = BookFactoryProvider.createBook(bookDTO);
        var validatorContext = validateBook(book);
        log.info("Book validation passed: {}", validatorContext);
        return this.bookRepository.save(book);
    }

    private ValidatorContext validateBook(Book book) {
        var validatorContext = ValidatorContext
                .builder()
                .add("book", book)
                .build();
        return ValidatorExecutor
                .validate(
                        validatorContext,
                        titleBookValidator,
                        authorBookValidator
                );
    }

}
