package com.kclab.library.application.service.factory;

import com.kclab.library.domain.enums.BookStatus;
import com.kclab.library.domain.enums.BookType;
import com.kclab.library.domain.model.Book;

public class FictionBookFactory implements BookFactory {

    @Override
    public Book createBook(String id, String title, String author, String format) {
        return Book.builder()
                .id(id)
                .title(title)
                .author(author)
                .type(BookType.NON_FICTION.getValue())
                .format(format)
                .status(BookStatus.AVAILABLE.getValue())
                .build();
    }


}
