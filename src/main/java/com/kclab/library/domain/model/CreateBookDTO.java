package com.kclab.library.domain.model;

import com.kclab.library.domain.enums.BookFormat;
import com.kclab.library.domain.enums.BookType;
import lombok.Builder;

@Builder
public record CreateBookDTO(
        String title,
        String author,
        BookType type,
        BookFormat format
) {
}
