package com.example.stockmicroservice.category.infrastructure.mapper;

import com.example.stockmicroservice.category.domain.model.CategoryModel;
import com.example.stockmicroservice.category.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    CategoryEntity modelToEntity(CategoryModel categoryModel);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    CategoryModel categoryEntityToModel(CategoryEntity categoryEntity);

    List<CategoryModel> entityListToModelList(List<CategoryEntity> categoryEntities);
}
