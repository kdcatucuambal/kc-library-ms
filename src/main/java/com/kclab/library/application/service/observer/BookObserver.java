package com.kclab.library.application.service.observer;

import com.kclab.library.domain.model.Book;

public interface BookObserver {
    void onBookUpdated(Book book);
}
