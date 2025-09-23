package com.kclab.library.application.service.factory.abs;

import com.kclab.library.application.service.factory.BookFactory;
import com.kclab.library.application.service.factory.FictionBookFactory;
import com.kclab.library.application.service.factory.NonFictionBookFactory;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.CreateBookDTO;

public class DigitalBookFactory implements AbstractBookFactory {

    private final BookFactory fictionFactory = new FictionBookFactory();
    private final BookFactory nonFictionFactory = new NonFictionBookFactory();

    @Override
    public Book createFictionBook(CreateBookDTO bookDTO) {
        return fictionFactory.createBook(bookDTO);
    }

    @Override
    public Book createNonFictionBook(CreateBookDTO bookDTO) {
        return nonFictionFactory.createBook(bookDTO);
    }
}
