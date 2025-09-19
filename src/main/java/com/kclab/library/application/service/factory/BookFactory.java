package com.kclab.library.application.service.factory;

import com.kclab.library.domain.model.Book;

public interface BookFactory {
    Book createBook(String id, String title, String author, String format);
}
