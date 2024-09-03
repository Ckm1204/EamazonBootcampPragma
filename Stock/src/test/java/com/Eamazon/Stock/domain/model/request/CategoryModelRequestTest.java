package com.Eamazon.Stock.domain.model.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryModelRequestTest {

    @Test
    public void testGetName() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setName("TestName");
        assertEquals("TestName", categoryModelRequest.getName());
    }

    @Test
    public void testSetName() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setName("TestName");
        assertEquals("TestName", categoryModelRequest.getName());
    }

    @Test
    public void testGetDescription() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setDescription("TestDescription");
        assertEquals("TestDescription", categoryModelRequest.getDescription());
    }

    @Test
    public void testSetDescription() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setDescription("TestDescription");
        assertEquals("TestDescription", categoryModelRequest.getDescription());
    }
}