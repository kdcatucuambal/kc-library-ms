package com.kclab.library.application.service.factory;

import com.kclab.library.application.service.factory.abs.AbstractBookFactory;
import com.kclab.library.application.service.factory.abs.DigitalBookFactory;
import com.kclab.library.application.service.factory.abs.PhysicalBookFactory;
import com.kclab.library.domain.model.Book;

public class BookFactoryProvider {


    public static AbstractBookFactory getBookFactory(String format){
        return switch (format) {
            case "PHYSICAL" -> new PhysicalBookFactory();
            case "DIGITAL" -> new DigitalBookFactory();
            default -> throw new IllegalArgumentException("Invalid book format: " + format);
        };
    }

    public static Book createBook(String format, String type, String title, String author, String id){
        var bookFactory = getBookFactory(format);
        return switch (type) {
            case "FICTION" -> bookFactory.createFictionBook(id, title, author);
            case "NON_FICTION" -> bookFactory.createNonFictionBook(id, title, author);
            default -> throw new IllegalArgumentException("Invalid book type: " + type);
        };



    }


}
