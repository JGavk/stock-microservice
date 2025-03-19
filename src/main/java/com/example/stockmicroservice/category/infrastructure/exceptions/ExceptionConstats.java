package com.example.stockmicroservice.category.infrastructure.exceptions;

public class ExceptionConstats {
    private ExceptionConstats() {}

    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String NAME_MIN_SIZE_MESSAGE = "The name of the category can not be 0 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION_MESSAGE = "The category already exists";
}
