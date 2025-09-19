package com.kclab.library.application.service.factory.abs;

import com.kclab.library.application.service.factory.BookFactory;
import com.kclab.library.application.service.factory.FictionBookFactory;
import com.kclab.library.application.service.factory.NonFictionBookFactory;
import com.kclab.library.domain.enums.BookFormat;
import com.kclab.library.domain.model.Book;

public class DigitalBookFactory implements AbstractBookFactory {

    private final BookFactory fictionFactory = new FictionBookFactory();
    private final BookFactory nonFictionFactory = new NonFictionBookFactory();

    @Override
    public Book createFictionBook(String id, String title, String author) {
        return fictionFactory.createBook(id, title, author, BookFormat.DIGITAL.getValue());
    }

    @Override
    public Book createNonFictionBook(String id, String title, String author) {
        return nonFictionFactory.createBook(id, title, author, BookFormat.DIGITAL.getValue());
    }
}
