package com.example.stockmicroservice.commons.configurations.beans;

import com.example.stockmicroservice.category.domain.ports.in.CategoryServicePort;
import com.example.stockmicroservice.category.domain.ports.out.CategoryPersistencePort;
import com.example.stockmicroservice.category.domain.usecases.CategoryUse;
import com.example.stockmicroservice.category.infrastructure.adapters.CategoryPersistenceAdapter;
import com.example.stockmicroservice.category.infrastructure.mapper.CategoryEntityMapper;
import com.example.stockmicroservice.category.infrastructure.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUse(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }
}
