package com.kclab.library.infrastructure.output.repository.mapper;


import com.kclab.library.domain.model.Book;
import com.kclab.library.infrastructure.output.repository.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    BookEntity toEntity(Book book);


    Book toDomain(BookEntity bookEntity);


}
