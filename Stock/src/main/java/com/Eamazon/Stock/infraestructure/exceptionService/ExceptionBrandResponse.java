package com.Eamazon.Stock.infraestructure.exceptionService;

public enum ExceptionBrandResponse {


        BRAND_NOT_FOUND("No Brand was found with that number"),
        BRAND_ALREADY_EXISTS("There is already a Brand"),
        NO_DATA_FOUND("No data found for the requested petition"),
        NAME_TOO_LONG("The name is too long"),
        DESCRIPTION_TOO_LONG("The description is too long");


        private String message;

        ExceptionBrandResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;

        }
}
