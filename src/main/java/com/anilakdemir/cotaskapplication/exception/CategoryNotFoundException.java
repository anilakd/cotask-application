package com.anilakdemir.cotaskapplication.exception;

public class CategoryNotFoundException extends BaseException {

    public CategoryNotFoundException(String field, String value) {
        super(String.format("%s by %s: %s", ErrorCode.CATEGORY_NOT_FOUND.getMessage(), field ,value));
    }
}
