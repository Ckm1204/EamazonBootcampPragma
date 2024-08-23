package com.Eamazon.Stock.infraestructure.exceptionService;


import com.Eamazon.Stock.infraestructure.exception.NameTooLongException;

public enum ExceptionCategoryResponse {

    CATEGORY_NOT_FOUND("No Category was found with that number"),
    CATEGORY_ALREADY_EXISTS("There is already a Category"),
    NO_DATA_FOUND("No data found for the requested petition"),
    NAME_TOO_LONG("The name is too long"),
    DESCRIPTION_TOO_LONG("The description is too long")
    ;



    private String message;

    ExceptionCategoryResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}