package com.anilakdemir.cotaskapplication.controller;

import com.anilakdemir.cotaskapplication.dto.request.category.CategoryCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.category.CategoryResponse;
import com.anilakdemir.cotaskapplication.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> create(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
        ApiResponse<CategoryResponse> response = categoryService.save(categoryCreateRequest);
        return ResponseEntity.ok(response);
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> updateName(@Valid @NotNull @RequestParam UUID id, @NotBlank @RequestParam String name) {
        ApiResponse<CategoryResponse> response = categoryService.updateCategoryName(id, name);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<String>> deleteById(@RequestParam UUID id) {
        ApiResponse<String> response = categoryService.deleteById(id);
        return ResponseEntity.ok(response);
    }
}
