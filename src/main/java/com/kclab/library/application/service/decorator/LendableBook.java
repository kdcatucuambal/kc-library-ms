package com.kclab.library.application.service.decorator;

import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.domain.enums.BookStatus;
import com.kclab.library.domain.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
public class LendableBook extends BookDecorator {

    private String borrowerName;
    private final BookRepositoryOutputPort bookRepository;

    public LendableBook(BookOperations bookOperations, BookRepositoryOutputPort bookRepository) {
        super(bookOperations);
        this.bookRepository = bookRepository;
    }

    public boolean lendBook(String borrowerName) {
        if (isLoaned()) {
            log.info("Book already loaned to: {}", this.borrowerName);
            return false;
        }
        this.borrowerName = borrowerName;
        setStatus(BookStatus.LOANED.getValue());
        this.bookRepository.updateStatus(getBook());
        return true;
    }


    public boolean returnBook() {
        if (!isLoaned()) {
            log.info("Book is not currently loaned.");
            return false;
        }

        log.info("Book returned to: {}", this.borrowerName);
        this.borrowerName = null;
        setStatus(BookStatus.AVAILABLE.getValue());
        return true;
    }


    @Override
    public Book getBook() {
        return null;
    }

    // Getters adicionales
    public String getBorrowerName() {
        return borrowerName;
    }


    public boolean isLoaned() {
        var bookStatus = BookStatus.fromValue(bookRepository.findById(this.getBook().getId()).getStatus());
        return BookStatus.LOANED.equals(bookStatus);
    }
}