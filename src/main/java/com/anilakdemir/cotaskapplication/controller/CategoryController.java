package com.anilakdemir.cotaskapplication.controller;

import com.anilakdemir.cotaskapplication.dto.request.category.CategoryCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.category.CategoryResponse;
import com.anilakdemir.cotaskapplication.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CategoryCreateRequest categoryCreateRequest) {
        ApiResponse<CategoryResponse> response = categoryService.save(categoryCreateRequest);
        return ResponseEntity.ok(response);
    }
}
