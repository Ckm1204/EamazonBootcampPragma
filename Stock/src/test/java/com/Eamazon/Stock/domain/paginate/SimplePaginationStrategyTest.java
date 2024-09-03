package com.Eamazon.Stock.domain.paginate;

import com.Eamazon.Stock.domain.paginate.Mockito.MockNameable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimplePaginationStrategyTest {

    @Test
    public void testPaginateWithinBounds() {
        List<MockNameable> items = new ArrayList<>();
        items.add(new MockNameable("Item1"));
        items.add(new MockNameable("Item2"));
        items.add(new MockNameable("Item3"));
        items.add(new MockNameable("Item4"));

        SimplePaginationStrategy<MockNameable> strategy = new SimplePaginationStrategy<>();
        List<MockNameable> result = strategy.paginate(items, 0, 2);

        assertEquals(2, result.size());
        assertEquals("Item1", result.get(0).getName());
        assertEquals("Item2", result.get(1).getName());
    }

    @Test
    public void testPaginateExceedingBounds() {
        List<MockNameable> items = new ArrayList<>();
        items.add(new MockNameable("Item1"));
        items.add(new MockNameable("Item2"));
        items.add(new MockNameable("Item3"));
        items.add(new MockNameable("Item4"));

        SimplePaginationStrategy<MockNameable> strategy = new SimplePaginationStrategy<>();
        List<MockNameable> result = strategy.paginate(items, 1, 3);

        assertEquals(1, result.size());
        assertEquals("Item4", result.get(0).getName());
    }

    @Test
    public void testPaginateEmptyResult() {
        List<MockNameable> items = new ArrayList<>();
        items.add(new MockNameable("Item1"));
        items.add(new MockNameable("Item2"));

        SimplePaginationStrategy<MockNameable> strategy = new SimplePaginationStrategy<>();
        List<MockNameable> result = strategy.paginate(items, 2, 2);

        assertTrue(result.isEmpty());
    }
}