package com.kclab.library.application.service.factory.abs;

import com.kclab.library.domain.model.Book;

public interface AbstractBookFactory {

    Book createFictionBook(String id, String title, String author);
    Book createNonFictionBook(String id, String title, String author);

}
