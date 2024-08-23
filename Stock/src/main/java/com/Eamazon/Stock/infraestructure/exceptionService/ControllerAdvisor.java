package com.Eamazon.Stock.infraestructure.exceptionService;

import com.Eamazon.Stock.infraestructure.exception.CategoryNameAlreadyExistException;
import com.Eamazon.Stock.infraestructure.exception.DescriptionTooLongException;
import com.Eamazon.Stock.infraestructure.exception.NameTooLongException;
import com.Eamazon.Stock.infraestructure.exception.NoDataFoundException;
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


}