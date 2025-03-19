package com.example.stockmicroservice.commons.configurations.utils;

public final class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String SAVE_CATEGORY_RESPONSE_MESSAGE = "Category created successfully.";
    public static final String NOT_BLANK_CATEGORY_NAME ="Category name cannot be blank.";
    public static final String NOT_BLANK_CATEGORY_DESCRIPTION ="Category description cannot be blank.";
    public static final String PAGEABLE_FIELD_NAME = "name";
}
