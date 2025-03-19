package com.example.stockmicroservice.category.domain.exceptions;
//Exception to manage the maximun characters for a description

public class MaxCharacterException extends RuntimeException {
    public MaxCharacterException() {
        super("Maximum number of characters exceeded");
    }
}
