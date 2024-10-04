package com.Eamazon.Stock.infraestructure.exceptionService;

import com.Eamazon.Stock.infraestructure.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(CategoryNameAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> serviceCategoryNameAlreadyExistException(
            CategoryNameAlreadyExistException categoryNameAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionCategoryResponse.CATEGORY_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionCategoryResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(NameTooLongException.class)
    public ResponseEntity<Map<String, String>> handleNameTooLongException(
            NameTooLongException nameTooLongException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionCategoryResponse.NAME_TOO_LONG.getMessage()));
    }

    @ExceptionHandler(DescriptionTooLongException.class)
    public ResponseEntity<Map<String, String>> handleDescriptionTooLongException(
            DescriptionTooLongException descriptionTooLongException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionCategoryResponse.DESCRIPTION_TOO_LONG.getMessage()));
    }

    @ExceptionHandler(BrandNameAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> serviceBrandNameAlreadyExistException(
            BrandNameAlreadyExistException brandNameAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionBrandResponse.BRAND_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(ItemBetweenOneAndThreeCategoriesException.class)
    public ResponseEntity<Map<String, String>> serviceItemBetweenOneAndThreeCategoriesException(
            ItemBetweenOneAndThreeCategoriesException itemBetweenOneAndThreeCategoriesException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionItemResponse.ITEM_BETWEEN_ONE_AND_THREE_CATEGORIES.getMessage()));
    }

    @ExceptionHandler(ItemCategoriesDuplicatedException.class)
    public ResponseEntity<Map<String, String>> serviceItemCategoriesDuplicatedException(
            ItemCategoriesDuplicatedException itemCategoriesDuplicatedException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionItemResponse.ITEM_CATEGORIES_DUPLICATED.getMessage()));
    }

    @ExceptionHandler(ItemBrandNotNullException.class)
    public ResponseEntity<Map<String, String>> serviceItemBrandNotNullException(
            ItemBrandNotNullException itemBrandNotNullException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionItemResponse.ITEM_BRAND_NOT_NULL.getMessage()));
    }
    @ExceptionHandler(StockNotNegativeException.class)
    public ResponseEntity<Map<String, String>> serviceStockException(
            StockNotNegativeException stockNotNegativeException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionItemResponse.STOCK_EXCEPTION.getMessage()));
    }

    @ExceptionHandler(StockIdNotExistException.class)
    public ResponseEntity<Map<String, String>> serviceStockIdNotExistException(
            StockIdNotExistException stockIdNotExistException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionItemResponse.ITEM_NOT_FOUND.getMessage()));
    }
}