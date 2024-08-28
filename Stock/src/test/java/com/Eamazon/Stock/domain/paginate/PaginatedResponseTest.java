package com.Eamazon.Stock.domain.paginate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaginatedResponseTest {

    private PaginatedResponse<String> paginatedResponse;
    private List<String> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    @BeforeEach
    void setUp() {
        content = Arrays.asList("item1", "item2", "item3");
        page = 1;
        size = 3;
        totalElements = 10;
        totalPages = 4;
        paginatedResponse = new PaginatedResponse<>(content, page, size, totalElements, totalPages);
    }

    @AfterEach
    void tearDown() {
        paginatedResponse = null;
    }

    @Test
    void getContent() {
        assertEquals(content, paginatedResponse.getContent());
    }

    @Test
    void getPage() {
        assertEquals(page, paginatedResponse.getPage());
    }

    @Test
    void getSize() {
        assertEquals(size, paginatedResponse.getSize());
    }

    @Test
    void getTotalElements() {
        assertEquals(totalElements, paginatedResponse.getTotalElements());
    }

    @Test
    void getTotalPages() {
        assertEquals(totalPages, paginatedResponse.getTotalPages());
    }
}