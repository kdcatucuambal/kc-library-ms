package com.kclab.library.application.service;

import com.kclab.library.application.input.port.QueryBookProviderInputPort;
import com.kclab.library.application.service.strategy.FindStrategy;
import com.kclab.library.domain.model.Book;
import com.kclab.library.domain.model.QueryBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.kclab.library.shared.Util.getStrategyFinder;

@Service
@RequiredArgsConstructor
public class QueryBookProviderService implements QueryBookProviderInputPort {

    private final Map<String, FindStrategy> findStrategies;

    @Override
    public List<Book> getBooks(QueryBookRequest request) {
        var finderRequest = getStrategyFinder(request);
        return findStrategies.get(finderRequest.getStrategyFinder()).find(finderRequest);
    }


}
