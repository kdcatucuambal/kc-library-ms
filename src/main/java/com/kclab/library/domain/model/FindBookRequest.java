package com.kclab.library.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindBookRequest {

    private String strategyFinder;
    private String value;
    private String limit;
    private String offset;

}
