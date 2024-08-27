package com.Eamazon.Stock.domain.paginate;

import java.util.List;

public interface SortingStrategy<T> {
    void sort(List<T> items, boolean ascending);
}
