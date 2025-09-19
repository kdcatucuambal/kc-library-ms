package com.kclab.library.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Book {

    private String id;
    private String title;
    private String author;
    private String type;
    private String format;
    private String status;


}
