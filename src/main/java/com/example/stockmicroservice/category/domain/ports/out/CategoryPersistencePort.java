package com.example.stockmicroservice.category.domain.ports.out;

import com.example.stockmicroservice.category.domain.model.CategoryModel;

import java.util.List;

public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List<CategoryModel> getAllCategories(Integer page, Integer size);
}
