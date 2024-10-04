package com.Eamazon.Stock.infraestructure.exceptionService;

public enum ExceptionItemResponse {

        ITEM_NOT_FOUND("No Item was found with that number"),
        ITEM_ALREADY_EXISTS("There is already a Item"),
        NO_DATA_FOUND("No data found for the requested petition"),
        NAME_TOO_LONG("The name is too long"),
        DESCRIPTION_TOO_LONG("The description is too long"),
        ITEM_BETWEEN_ONE_AND_THREE_CATEGORIES("The item must have between 1 and 3 categories"),
        ITEM_CATEGORIES_DUPLICATED("The item has duplicated categories"),
        ITEM_BRAND_NOT_NULL("The item must have a brand"),
        STOCK_EXCEPTION("The stock must be greater than 0")
        ;
        private String message;

        ExceptionItemResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
}
