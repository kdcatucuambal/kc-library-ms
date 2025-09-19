package com.kclab.library.application.input.port;

import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.QueryBookRequest;

import java.util.List;

public interface QueryBookProviderInputPort {

    List<Book> getBooks(QueryBookRequest request);


}
