package com.example.petshopproject.dto;

import com.example.petshopproject.entity.Category;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String description;
    private int price;
    @Lob
    private byte[] image;

    private String category;
}
