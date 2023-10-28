package com.anilakdemir.cotaskapplication.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    CATEGORY_ALREADY_EXISTS("Category is already exists");


    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }


}
