package com.anilakdemir.cotaskapplication.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    CATEGORY_ALREADY_EXISTS("Category is already exists"),
    CATEGORY_NOT_FOUND("Category could not found")
    ;


    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }


}
