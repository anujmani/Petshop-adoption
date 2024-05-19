package com.example.petshopproject.services;

import com.example.petshopproject.dto.CategoryDto;
import com.example.petshopproject.entity.Category;
import com.example.petshopproject.repositories.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepo categoryRepo;

    public Category createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories= categoryRepo.findAll();
        return categories;
    }
}
