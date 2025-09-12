package com.kclab.library.infrastructure.output.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class BookEntity {

    @Id
    private String id;
    private String title;
    private String author;
    private String type;
    private String format;
    private String status;


}