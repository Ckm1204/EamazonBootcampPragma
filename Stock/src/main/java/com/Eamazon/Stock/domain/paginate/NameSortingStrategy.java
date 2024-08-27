package com.Eamazon.Stock.domain.paginate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameSortingStrategy<T extends Nameable> implements SortingStrategy<T> {
    @Override
    public void sort(List<T> items, boolean ascending) {
        Comparator<T> comparator = Comparator.comparing(T::getName);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        items.sort(comparator);
    }
}
