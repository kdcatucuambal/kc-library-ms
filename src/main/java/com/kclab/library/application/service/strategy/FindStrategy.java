package com.kclab.library.application.service.strategy;

import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.FindBookRequest;

import java.util.List;

public interface FindStrategy {
    List<Book> find(FindBookRequest request);
}
