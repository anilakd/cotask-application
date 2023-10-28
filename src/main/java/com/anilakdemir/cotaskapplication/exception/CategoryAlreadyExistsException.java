package com.anilakdemir.cotaskapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CategoryAlreadyExistsException extends BaseException {
    public CategoryAlreadyExistsException(ErrorCode errorCode) {
        super(errorCode);
    }
}
