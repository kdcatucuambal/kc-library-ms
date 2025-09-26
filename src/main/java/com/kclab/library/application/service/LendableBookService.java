package com.kclab.library.application.service;


import com.kclab.library.application.input.port.LendableBookServiceInputPort;
import com.kclab.library.application.output.port.BookRepositoryOutputPort;
import com.kclab.library.application.service.decorator.BookAdapter;
import com.kclab.library.application.service.decorator.LendableBook;
import com.kclab.library.application.service.observer.BookSubject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class LendableBookService implements LendableBookServiceInputPort {

    private final BookRepositoryOutputPort bookRepository;
    private final BookSubject bookSubject;

    @Override
    public boolean execute(String bookId, String borrowerName) {
        var bookLoanAdapter = new BookAdapter(bookRepository.findById(bookId));
        var lendableBook = new LendableBook(bookLoanAdapter, bookRepository);
        var wasLent = lendableBook.lendBook(borrowerName);
        bookSubject.notifyBookLent(bookLoanAdapter.getBook());
        return wasLent;
    }
}
