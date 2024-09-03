package com.Eamazon.Stock.domain.model.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandModelRequestTest {

    @Test
    public void testGetName() {
        BrandModelRequest brandModelRequest = new BrandModelRequest();
        brandModelRequest.setName("TestName");
        assertEquals("TestName", brandModelRequest.getName());
    }

    @Test
    public void testSetName() {
        BrandModelRequest brandModelRequest = new BrandModelRequest();
        brandModelRequest.setName("TestName");
        assertEquals("TestName", brandModelRequest.getName());
    }

    @Test
    public void testGetDescription() {
        BrandModelRequest brandModelRequest = new BrandModelRequest();
        brandModelRequest.setDescription("TestDescription");
        assertEquals("TestDescription", brandModelRequest.getDescription());
    }

    @Test
    public void testSetDescription() {
        BrandModelRequest brandModelRequest = new BrandModelRequest();
        brandModelRequest.setDescription("TestDescription");
        assertEquals("TestDescription", brandModelRequest.getDescription());
    }
}