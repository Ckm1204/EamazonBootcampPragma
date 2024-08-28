package com.Eamazon.Stock.domain.paginate;

// Unit test for NameSortingStrategy

import com.Eamazon.Stock.domain.paginate.Mockito.MockNameable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameSortingStrategyTest {

    @Test
    void sortAscending() {
        List<MockNameable> items = new ArrayList<>();
        items.add(new MockNameable("Charlie"));
        items.add(new MockNameable("Alice"));
        items.add(new MockNameable("Bob"));

        NameSortingStrategy<MockNameable> strategy = new NameSortingStrategy<>();
        strategy.sort(items, true);

        assertEquals("Alice", items.get(0).getName());
        assertEquals("Bob", items.get(1).getName());
        assertEquals("Charlie", items.get(2).getName());
    }

    @Test
    void sortDescending() {
        List<MockNameable> items = new ArrayList<>();
        items.add(new MockNameable("Charlie"));
        items.add(new MockNameable("Alice"));
        items.add(new MockNameable("Bob"));

        NameSortingStrategy<MockNameable> strategy = new NameSortingStrategy<>();
        strategy.sort(items, false);

        assertEquals("Charlie", items.get(0).getName());
        assertEquals("Bob", items.get(1).getName());
        assertEquals("Alice", items.get(2).getName());
    }
}