package com.kclab.library.infrastructure.output.repository;

import com.kclab.library.domain.model.Book;
import com.kclab.library.infrastructure.output.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookJPARepository extends JpaRepository<BookEntity, String> {
    Optional<BookEntity> findByTitle(String title);
    List<BookEntity> findByAuthor(String author);



}
