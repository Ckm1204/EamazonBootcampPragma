package com.Eamazon.Stock.domain.paginate.Mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockNameableTest {

    @Test
    public void testConstructorAndGetName() {
        MockNameable mockNameable = new MockNameable("TestName");
        assertEquals("TestName", mockNameable.getName());
    }
}