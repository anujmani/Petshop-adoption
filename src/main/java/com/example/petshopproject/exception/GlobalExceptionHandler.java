package com.example.petshopproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> resourceNotfoundExceptionHandler(ResourceNotFoundException re){
        Map<String, Object> map= new HashMap<>();
        map.put("status", HttpStatus.NOT_FOUND);
        map.put("message",re.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
