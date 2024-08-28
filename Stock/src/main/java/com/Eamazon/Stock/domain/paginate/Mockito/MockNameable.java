package com.Eamazon.Stock.domain.paginate.Mockito;

import com.Eamazon.Stock.domain.paginate.Nameable;

public class MockNameable implements Nameable {
    private final String name;

    public MockNameable(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}