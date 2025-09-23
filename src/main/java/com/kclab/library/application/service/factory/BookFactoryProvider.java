package com.kclab.library.application.service.factory;

import com.kclab.library.application.service.factory.abs.AbstractBookFactory;
import com.kclab.library.application.service.factory.abs.DigitalBookFactory;
import com.kclab.library.application.service.factory.abs.PhysicalBookFactory;
import com.kclab.library.domain.enums.BookFormat;
import com.kclab.library.domain.enums.BookType;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.CreateBookDTO;

public class BookFactoryProvider {


    public static AbstractBookFactory getBookFactory(BookFormat format){
        return switch (format) {
            case BookFormat.PHYSICAL -> new PhysicalBookFactory();
            case BookFormat.E_BOOK -> new DigitalBookFactory();
        };
    }

    public static Book createBook(CreateBookDTO bookDTO){
        var bookFactory = getBookFactory(bookDTO.format());
        return switch (bookDTO.type()) {
            case BookType.FICTION -> bookFactory.createFictionBook(bookDTO);
            case BookType.NON_FICTION -> bookFactory.createNonFictionBook(bookDTO);
        };

    }


}
