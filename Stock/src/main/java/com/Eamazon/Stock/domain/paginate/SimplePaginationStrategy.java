package com.Eamazon.Stock.domain.paginate;

import java.util.Collections;
import java.util.List;

public class SimplePaginationStrategy<T> implements PaginationStrategy<T> {
    @Override
    public List<T> paginate(List<T> items, int page, int size) {
        int fromIndex = Math.max(0, page * size);
        int toIndex = Math.min(items.size(), fromIndex + size);
        if (fromIndex > items.size()) {
            return Collections.emptyList();
        }
        return items.subList(fromIndex, toIndex);
    }
}