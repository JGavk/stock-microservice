package com.example.stockmicroservice.category.application.services.implementation;

import com.example.stockmicroservice.category.application.dto.request.SaveCategoryRequest;
import com.example.stockmicroservice.category.application.dto.response.CategoryResponse;
import com.example.stockmicroservice.category.application.dto.response.SaveCategoryResponse;
import com.example.stockmicroservice.category.application.mappers.CategoryDtoMapper;
import com.example.stockmicroservice.category.application.services.CategoryService;
import com.example.stockmicroservice.category.domain.model.CategoryModel;
import com.example.stockmicroservice.category.domain.ports.in.CategoryServicePort;
import com.example.stockmicroservice.category.infrastructure.exceptions.ExceptionConstats;
import com.example.stockmicroservice.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImplementation implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    @Autowired
    private final CategoryDtoMapper categoryDtoMapper;


    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {

        CategoryModel categoryModel = categoryDtoMapper.requestToModel(request);

        categoryServicePort.save(categoryDtoMapper.requestToModel(request));

        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public List<CategoryResponse> getAllCategories(Integer page, Integer size) {
        if (size < 1) {
            throw new IllegalArgumentException(ExceptionConstats.SIZE_MINIMUM_VALUE);
        }
        return categoryDtoMapper.modelToResponseList(categoryServicePort.getAllCategories(page, size));
    }

}
