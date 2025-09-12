package com.kclab.library.application.input.port;

import com.kclab.library.domain.model.Book;

public interface CreateBookInputPort {

    Book execute(Book book);

}
