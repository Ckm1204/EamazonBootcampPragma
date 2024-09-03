package com.Eamazon.Stock.domain.model.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryModelResponseTest {

    @Test
    public void testGetId() {
        CategoryModelResponse categoryModelResponse = new CategoryModelResponse();
        categoryModelResponse.setId(1);
        assertEquals(1, categoryModelResponse.getId());
    }

    @Test
    public void testSetId() {
        CategoryModelResponse categoryModelResponse = new CategoryModelResponse();
        categoryModelResponse.setId(1);
        assertEquals(1, categoryModelResponse.getId());
    }

    @Test
    public void testGetName() {
        CategoryModelResponse categoryModelResponse = new CategoryModelResponse();
        categoryModelResponse.setName("TestName");
        assertEquals("TestName", categoryModelResponse.getName());
    }

    @Test
    public void testSetName() {
        CategoryModelResponse categoryModelResponse = new CategoryModelResponse();
        categoryModelResponse.setName("TestName");
        assertEquals("TestName", categoryModelResponse.getName());
    }

    @Test
    public void testGetDescription() {
        CategoryModelResponse categoryModelResponse = new CategoryModelResponse();
        categoryModelResponse.setDescription("TestDescription");
        assertEquals("TestDescription", categoryModelResponse.getDescription());
    }

    @Test
    public void testSetDescription() {
        CategoryModelResponse categoryModelResponse = new CategoryModelResponse();
        categoryModelResponse.setDescription("TestDescription");
        assertEquals("TestDescription", categoryModelResponse.getDescription());
    }
}