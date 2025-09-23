package com.kclab.library.application.service.factory;

import com.kclab.library.domain.enums.BookStatus;
import com.kclab.library.domain.enums.BookType;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.CreateBookDTO;

import java.util.UUID;

public class NonFictionBookFactory implements BookFactory {

    @Override
    public Book createBook(CreateBookDTO bookDTO) {
        return Book.builder()
                .id(UUID.randomUUID().toString())
                .title(bookDTO.title())
                .author(bookDTO.author())
                .type(BookType.FICTION.getValue())
                .format(bookDTO.format().getValue())
                .status(BookStatus.AVAILABLE.getValue())
                .build();
    }


}
