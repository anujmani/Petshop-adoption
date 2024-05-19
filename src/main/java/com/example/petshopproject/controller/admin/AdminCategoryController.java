package com.example.petshopproject.controller.admin;

import com.example.petshopproject.dto.CategoryDto;
import com.example.petshopproject.entity.Category;
import com.example.petshopproject.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {
    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("/getCategory")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> category = categoryService.getAllCategory();
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
