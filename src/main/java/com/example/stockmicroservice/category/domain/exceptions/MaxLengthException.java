package com.example.stockmicroservice.category.domain.exceptions;

//Exception to manage the maximun length of a name
public class MaxLengthException extends RuntimeException {
    public MaxLengthException() {
        super();
    }
}
