package com.example.stockmicroservice.category.infrastructure.endpoints;

import com.example.stockmicroservice.category.application.dto.request.SaveCategoryRequest;
import com.example.stockmicroservice.category.application.dto.response.CategoryResponse;
import com.example.stockmicroservice.category.application.dto.response.SaveCategoryResponse;
import com.example.stockmicroservice.category.application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }

    @GetMapping("/get")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(categoryService.getAllCategories(page, size));
    }
}
