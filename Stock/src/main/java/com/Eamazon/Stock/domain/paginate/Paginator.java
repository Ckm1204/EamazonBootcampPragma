package com.Eamazon.Stock.domain.paginate;

import java.util.List;

public class Paginator<T> {
    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_SIZE = 10;

    private PaginationStrategy<T> paginationStrategy;
    private SortingStrategy<T> sortingStrategy;

    public Paginator(PaginationStrategy<T> paginationStrategy, SortingStrategy<T> sortingStrategy) {
        this.paginationStrategy = paginationStrategy;
        this.sortingStrategy = sortingStrategy;
    }

    public void setPaginationStrategy(PaginationStrategy<T> paginationStrategy) {
        this.paginationStrategy = paginationStrategy;
    }

    public void setSortingStrategy(SortingStrategy<T> sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public PaginationStrategy<T> getPaginationStrategy() {
        return paginationStrategy;
    }

    public SortingStrategy<T> getSortingStrategy() {
        return sortingStrategy;
    }

    public List<T> paginateAndSort(List<T> items, Integer page, Integer size, boolean ascending) {
        sortingStrategy.sort(items, ascending);
        int actualPage = (page != null) ? page : DEFAULT_PAGE;
        int actualSize = (size != null) ? size : DEFAULT_SIZE;
        return paginationStrategy.paginate(items, actualPage, actualSize);
    }
}