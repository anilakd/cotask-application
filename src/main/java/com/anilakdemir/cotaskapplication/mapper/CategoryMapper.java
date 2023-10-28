package com.anilakdemir.cotaskapplication.mapper;

import com.anilakdemir.cotaskapplication.dto.request.category.CategoryCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.category.CategoryResponse;
import com.anilakdemir.cotaskapplication.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryCreateRequest categoryCreateRequest);
    CategoryResponse toCategoryResponse(Category category);
}
