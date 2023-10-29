package com.anilakdemir.cotaskapplication.service.impl;

import com.anilakdemir.cotaskapplication.dto.request.category.CategoryCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.category.CategoryResponse;
import com.anilakdemir.cotaskapplication.exception.CategoryAlreadyExistsException;
import com.anilakdemir.cotaskapplication.exception.CategoryNotFoundException;
import com.anilakdemir.cotaskapplication.mapper.CategoryMapper;
import com.anilakdemir.cotaskapplication.model.Category;
import com.anilakdemir.cotaskapplication.repository.CategoryRepository;
import com.anilakdemir.cotaskapplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public ApiResponse<CategoryResponse> save(CategoryCreateRequest categoryCreateRequest) {

        checkCategoryIsExistsByName(categoryCreateRequest.getName());

        Category category = categoryMapper.toCategory(categoryCreateRequest);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponse response = categoryMapper.toCategoryResponse(savedCategory);

        return ApiResponse.success(response);
    }

    @Override
    public ApiResponse<CategoryResponse> updateCategoryName(UUID id, String name) {
        checkCategoryIsExistsByName(name);

        Category category = getCategoryById(id);
        category.setName(name);

        Category updatedCategory = categoryRepository.save(category);
        CategoryResponse response = categoryMapper.toCategoryResponse(updatedCategory);

        return ApiResponse.success(response);
    }

    @Override
    public ApiResponse<String> deleteById(UUID id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
        return ApiResponse.success(String.format("Successfully deleted by id: %s", id));
    }

    private Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("id", id.toString()));
    }

    private void checkCategoryIsExistsByName(String name) {
        boolean isCategoryExists = categoryRepository.existsByName(name);

        if (isCategoryExists) {
            throw new CategoryAlreadyExistsException("name", name);
        }
    }
}
