package com.kclab.library.infrastructure.output.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "book_entity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    private String id;
    private String title;
    private String author;
    private String type;
    private String format;
    private String status;


}