package com.kclab.library.application.service.observer;

import com.kclab.library.domain.model.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookSubject {

    private final List<BookObserver> observers = new CopyOnWriteArrayList<>();

    public void addObserver(BookObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookObserver observer) {
        observers.remove(observer);
    }

    public void notifyBookLent(Book book) {
        for (BookObserver observer : observers) {
            observer.onBookUpdated(book);
        }
    }

}
