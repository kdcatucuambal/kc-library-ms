package com.kclab.library.application.service.factory;

import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.CreateBookDTO;

public interface BookFactory {
    Book createBook(CreateBookDTO bookDTO);
}
