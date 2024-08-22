package com.Eamazon.Stock.infraestructure.exceptionService;


public enum ExceptionCategoryResponse {
    CATEGORY_NOT_FOUND("No Category was found with that number"),
    CATEGORY_ALREADY_EXISTS("There is already a Category"),
    NO_DATA_FOUND("No data found for the requested petition");


    private String message;

    ExceptionCategoryResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}