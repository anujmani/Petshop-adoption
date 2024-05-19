package com.example.petshopproject.services;

import com.example.petshopproject.dto.CategoryDto;
import com.example.petshopproject.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDto categoryDto);

    List<Category> getAllCategory();
}
