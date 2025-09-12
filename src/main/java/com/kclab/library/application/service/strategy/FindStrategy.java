package com.kclab.library.application.service.strategy;

import com.kclab.library.domain.model.Book;

import java.util.List;

public interface FindStrategy {
    List<Book> find(String query);
}
