package com.anilakdemir.cotaskapplication.exception;

public class DashboardNotFoundException extends BaseException{

    public DashboardNotFoundException(String field, String value) {
        super(String.format("%s by %s: %s", ErrorCode.CATEGORY_NOT_FOUND.getMessage(), field ,value));
    }
}
