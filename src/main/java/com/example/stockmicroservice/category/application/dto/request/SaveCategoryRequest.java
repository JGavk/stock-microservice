package com.example.stockmicroservice.category.application.dto.request;


import com.example.stockmicroservice.commons.configurations.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SaveCategoryRequest(@NotBlank(message = Constants.NOT_BLANK_CATEGORY_NAME) @Size(max=50) String name,
                                  @Size(max=90)@NotBlank(message = Constants.NOT_BLANK_CATEGORY_DESCRIPTION) String description) {

}
