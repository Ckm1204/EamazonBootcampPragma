package com.Eamazon.Stock.domain.paginate;

import com.Eamazon.Stock.domain.paginate.Mockito.MockNameable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PaginatorTest {

    private Paginator<MockNameable> paginator;
    private PaginationStrategy<MockNameable> paginationStrategy;
    private SortingStrategy<MockNameable> sortingStrategy;

    @BeforeEach
    public void setUp() {
        paginationStrategy = mock(PaginationStrategy.class);
        sortingStrategy = mock(SortingStrategy.class);
        paginator = new Paginator<>(paginationStrategy, sortingStrategy);
    }

    @Test
    public void testPaginateAndSort() {
        List<MockNameable> items = new ArrayList<>();
        items.add(new MockNameable("Charlie"));
        items.add(new MockNameable("Alice"));
        items.add(new MockNameable("Bob"));

        List<MockNameable> paginatedItems = new ArrayList<>();
        paginatedItems.add(new MockNameable("Alice"));
        paginatedItems.add(new MockNameable("Bob"));

        when(paginationStrategy.paginate(anyList(), anyInt(), anyInt())).thenReturn(paginatedItems);

        List<MockNameable> result = paginator.paginateAndSort(items, 0, 2, true);

        verify(sortingStrategy).sort(items, true);
        verify(paginationStrategy).paginate(items, 0, 2);
        assertEquals(paginatedItems, result);
    }

    @Test
    public void testSetPaginationStrategy() {
        PaginationStrategy<MockNameable> newPaginationStrategy = mock(PaginationStrategy.class);
        paginator.setPaginationStrategy(newPaginationStrategy);
        assertEquals(newPaginationStrategy, paginator.getPaginationStrategy());
    }

    @Test
    public void testSetSortingStrategy() {
        SortingStrategy<MockNameable> newSortingStrategy = mock(SortingStrategy.class);
        paginator.setSortingStrategy(newSortingStrategy);
        assertEquals(newSortingStrategy, paginator.getSortingStrategy());
    }
}