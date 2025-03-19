package com.example.stockmicroservice.category.domain.ports.in;

import com.example.stockmicroservice.category.domain.model.CategoryModel;

import java.util.List;

public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
    List<CategoryModel> getAllCategories(Integer page, Integer size);
}
