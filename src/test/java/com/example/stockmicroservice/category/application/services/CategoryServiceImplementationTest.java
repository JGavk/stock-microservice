package com.example.stockmicroservice.category.application.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.stockmicroservice.category.application.dto.request.SaveCategoryRequest;
import com.example.stockmicroservice.category.application.dto.response.CategoryResponse;
import com.example.stockmicroservice.category.application.dto.response.SaveCategoryResponse;
import com.example.stockmicroservice.category.application.mappers.CategoryDtoMapper;
import com.example.stockmicroservice.category.application.services.implementation.CategoryServiceImplementation;
import com.example.stockmicroservice.category.domain.model.CategoryModel;
import com.example.stockmicroservice.category.domain.ports.in.CategoryServicePort;
import com.example.stockmicroservice.category.infrastructure.exceptions.ExceptionConstats;
import com.example.stockmicroservice.commons.configurations.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplementationTest {

    @Mock
    private CategoryServicePort categoryServicePort;

    @Mock
    private CategoryDtoMapper categoryDtoMapper;

    @InjectMocks
    private CategoryServiceImplementation categoryService;

    @Test
    public void testSave() {
        SaveCategoryRequest request = new SaveCategoryRequest("AppPements", "Some AppPements");
        CategoryModel categoryModel = new CategoryModel(1L, "House", "Some houses");
        SaveCategoryResponse expectedResponse = new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());

        when(categoryDtoMapper.requestToModel(request)).thenReturn(categoryModel);

        SaveCategoryResponse actualResponse = categoryService.save(request);

        assertNotNull(actualResponse);
        assertEquals(expectedResponse.message(), actualResponse.message());

        verify(categoryDtoMapper, times(1)).requestToModel(request);
        verify(categoryServicePort, times(1)).save(categoryModel);
    }
    @Test
    public void testGetAllCategories() {

        int page = 0;
        int size = 10;
        List<CategoryModel> categoryModels = Arrays.asList(
                new CategoryModel(1L, "House", "House"),
                new CategoryModel(2L, "Aparment", "Aparment thing")
        );
        List<CategoryResponse> expectedResponses = Arrays.asList(
                new CategoryResponse(1L, "House", "House"),
                new CategoryResponse(2L, "Aparment", "Aparment thing")
        );

        when(categoryServicePort.getAllCategories(page, size)).thenReturn(categoryModels);
        when(categoryDtoMapper.modelToResponseList(categoryModels)).thenReturn(expectedResponses);

        List<CategoryResponse> actualResponses = categoryService.getAllCategories(page, size);

        assertNotNull(actualResponses);
        assertEquals(expectedResponses.size(), actualResponses.size());
        assertEquals(expectedResponses.get(0).name(), actualResponses.get(0).name());
        assertEquals(expectedResponses.get(1).name(), actualResponses.get(1).name());

        verify(categoryServicePort, times(1)).getAllCategories(page, size);
        verify(categoryDtoMapper, times(1)).modelToResponseList(categoryModels);
    }
    @Test
    public void testGetAllCategories_InvalidSize() {
        int page = 0;
        int size = 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            categoryService.getAllCategories(page, size);
        });

        assertEquals(ExceptionConstats.SIZE_MINIMUM_VALUE, exception.getMessage());

        verify(categoryServicePort, never()).getAllCategories(anyInt(), anyInt());
        verify(categoryDtoMapper, never()).modelToResponseList(anyList());
    }


}