package com.Eamazon.Stock.domain.model.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandModelResponseTest {

    @Test
    public void testGetId() {
        BrandModelResponse brandModelResponse = new BrandModelResponse();
        brandModelResponse.setId(1);
        assertEquals(1, brandModelResponse.getId());
    }

    @Test
    public void testSetId() {
        BrandModelResponse brandModelResponse = new BrandModelResponse();
        brandModelResponse.setId(1);
        assertEquals(1, brandModelResponse.getId());
    }

    @Test
    public void testGetName() {
        BrandModelResponse brandModelResponse = new BrandModelResponse();
        brandModelResponse.setName("TestName");
        assertEquals("TestName", brandModelResponse.getName());
    }

    @Test
    public void testSetName() {
        BrandModelResponse brandModelResponse = new BrandModelResponse();
        brandModelResponse.setName("TestName");
        assertEquals("TestName", brandModelResponse.getName());
    }

    @Test
    public void testGetDescription() {
        BrandModelResponse brandModelResponse = new BrandModelResponse();
        brandModelResponse.setDescription("TestDescription");
        assertEquals("TestDescription", brandModelResponse.getDescription());
    }

    @Test
    public void testSetDescription() {
        BrandModelResponse brandModelResponse = new BrandModelResponse();
        brandModelResponse.setDescription("TestDescription");
        assertEquals("TestDescription", brandModelResponse.getDescription());
    }
}