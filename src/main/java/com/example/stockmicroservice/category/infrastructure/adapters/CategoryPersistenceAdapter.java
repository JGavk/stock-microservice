package com.example.stockmicroservice.category.infrastructure.adapters;

import com.example.stockmicroservice.category.domain.model.CategoryModel;
import com.example.stockmicroservice.category.domain.ports.out.CategoryPersistencePort;
import com.example.stockmicroservice.category.infrastructure.exceptions.ExceptionConstats;
import com.example.stockmicroservice.category.infrastructure.mapper.CategoryEntityMapper;
import com.example.stockmicroservice.category.infrastructure.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    @Transactional
    public void save(CategoryModel categoryModel){
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.categoryEntityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }

    @Override
    public List<CategoryModel> getAllCategories(Integer page, Integer size) {
        if (size < 1) {
            throw new IllegalArgumentException(ExceptionConstats.SIZE_MINIMUM_VALUE);
        }
        Pageable pagination = PageRequest.of(page, size);
        return categoryEntityMapper.entityListToModelList(categoryRepository.findAll(pagination).getContent());
    }
}
