package com.kclab.library.application.service.observer;

import com.kclab.library.domain.model.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookLendingObserver implements BookObserver {
    @Override
    public void onBookUpdated(Book book) {
        log.info("Book with ID: {} has been lent. New status: {}", book.getId(), book.getStatus());
    }
}
