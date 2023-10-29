package com.anilakdemir.cotaskapplication.service;

import com.anilakdemir.cotaskapplication.dto.request.category.CategoryCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.category.CategoryResponse;

import java.util.UUID;

public interface CategoryService {
    ApiResponse<CategoryResponse> save(CategoryCreateRequest categoryCreateRequest);

    ApiResponse<CategoryResponse> updateCategoryName(UUID id, String name);

    ApiResponse<String> deleteById(UUID id);
}
