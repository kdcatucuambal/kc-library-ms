package com.kclab.library.application.input.port;

import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.CreateBookDTO;

public interface CreateBookInputPort {

    Book execute(CreateBookDTO bookDTO);

}
