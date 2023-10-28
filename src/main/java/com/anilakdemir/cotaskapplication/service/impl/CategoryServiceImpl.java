package com.anilakdemir.cotaskapplication.service.impl;

import com.anilakdemir.cotaskapplication.dto.request.category.CategoryCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.category.CategoryResponse;
import com.anilakdemir.cotaskapplication.exception.CategoryAlreadyExistsException;
import com.anilakdemir.cotaskapplication.exception.ErrorCode;
import com.anilakdemir.cotaskapplication.mapper.CategoryMapper;
import com.anilakdemir.cotaskapplication.model.Category;
import com.anilakdemir.cotaskapplication.repository.CategoryRepository;
import com.anilakdemir.cotaskapplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public ApiResponse<CategoryResponse> save(CategoryCreateRequest categoryCreateRequest) {

        checkCategoryIsExists(categoryCreateRequest);

        Category category = categoryMapper.toCategory(categoryCreateRequest);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponse response = categoryMapper.toCategoryResponse(savedCategory);

        return ApiResponse.success(response);
    }

    private void checkCategoryIsExists(CategoryCreateRequest categoryCreateRequest) {

        boolean isCategoryExists = categoryRepository.existsByName(categoryCreateRequest.getName());

        if (isCategoryExists) {
            throw new CategoryAlreadyExistsException(ErrorCode.CATEGORY_ALREADY_EXISTS);
        }
    }
}
