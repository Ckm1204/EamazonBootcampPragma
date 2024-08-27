package com.Eamazon.Stock.domain.paginate;

import java.util.List;

public interface PaginationStrategy<T> {
    List<T> paginate(List<T> items, int page, int size);
}
