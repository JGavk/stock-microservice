package com.example.stockmicroservice.category.infrastructure.exceptions;

import com.example.stockmicroservice.category.domain.exceptions.CategoryAlreadyExistsException;
import com.example.stockmicroservice.category.domain.exceptions.MaxCharacterException;
import com.example.stockmicroservice.category.domain.exceptions.MaxLengthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(MaxCharacterException.class)
    public ResponseEntity<ExceptionResponse> handleMaxCharacterException(MaxCharacterException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstats.NAME_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(MaxLengthException.class)
    public ResponseEntity<ExceptionResponse> handleMaxLengthException(MaxLengthException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstats.DESCRIPTION_MAX_SIZE_MESSAGE,
                LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstats.CATEGORY_EXISTS_EXCEPTION_MESSAGE,
                LocalDateTime.now()));
    }
}
