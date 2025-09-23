package com.kclab.library.application.service.factory.abs;

import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.CreateBookDTO;

public interface AbstractBookFactory {

    Book createFictionBook(CreateBookDTO createBookDTO);
    Book createNonFictionBook(CreateBookDTO createBookDTO);

}
