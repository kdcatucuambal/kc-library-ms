package com.kclab.library.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryBookRequest {
    private String title;
    private String author;
    private String limit;
    private String offset;


}
