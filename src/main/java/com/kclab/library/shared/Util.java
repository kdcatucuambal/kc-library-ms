package com.kclab.library.shared;

import com.kclab.library.domain.model.FindBookRequest;
import com.kclab.library.domain.model.QueryBookRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {


    public static FindBookRequest getStrategyFinder(QueryBookRequest request) {
        var requestBuilder = FindBookRequest.builder()
                .limit(request.getLimit())
                .offset(request.getOffset());
        if (request.getTitle() != null && !request.getTitle().isEmpty()) {
            requestBuilder.strategyFinder(Constant.FIND_BOOK_BY_TITLE);
            requestBuilder.value(request.getTitle());
        } else if (request.getAuthor() != null && !request.getAuthor().isEmpty()) {
            requestBuilder.strategyFinder(Constant.FIND_BOOK_BY_AUTHOR);
            requestBuilder.value(request.getAuthor());
        } else {
            requestBuilder.strategyFinder(Constant.FIND_ALL_BOOKS);
        }
        return requestBuilder.build();
    }

}
