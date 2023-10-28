package com.anilakdemir.cotaskapplication.service;

import com.anilakdemir.cotaskapplication.dto.request.category.CategoryCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.category.CategoryResponse;

public interface CategoryService {
    ApiResponse<CategoryResponse> save(CategoryCreateRequest categoryCreateRequest);
}
