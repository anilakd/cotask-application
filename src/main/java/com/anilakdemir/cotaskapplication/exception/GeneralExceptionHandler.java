package com.anilakdemir.cotaskapplication.exception;

import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GeneralExceptionHandler{

    // This method will run when there is a validation error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, Object>>> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<Map<String, String>> errors = new ArrayList<>();

        // Add all the errors to the map by looping through them.
        result.getFieldErrors().forEach(fieldError -> {
            Map<String, String> error = new HashMap<>();
            error.put("field", fieldError.getField());
            error.put("message", fieldError.getDefaultMessage());
            errors.add(error);
        });

        // Create error messages in JSON format
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("status", HttpStatus.BAD_REQUEST.value());
        errorMap.put("errors", errors);

        ApiResponse<Map<String, Object>> response = ApiResponse.fail(errorMap);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException exception) {
        // Create error messages in JSON format
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", exception.getMessage());
        ApiResponse<Map<String, String>> response = ApiResponse.fail(errorMap);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", exception.getMessage());

        ApiResponse<Map<String, String>> response = ApiResponse.fail(errorMap);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
