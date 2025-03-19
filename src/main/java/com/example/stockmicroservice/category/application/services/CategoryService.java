package com.example.stockmicroservice.category.application.services;

import com.example.stockmicroservice.category.application.dto.request.SaveCategoryRequest;
import com.example.stockmicroservice.category.application.dto.response.CategoryResponse;
import com.example.stockmicroservice.category.application.dto.response.SaveCategoryResponse;

import java.util.List;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);
    List<CategoryResponse> getAllCategories(Integer page, Integer size );
}
