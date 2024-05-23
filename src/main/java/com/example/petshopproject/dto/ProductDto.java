package com.example.petshopproject.dto;

import com.example.petshopproject.entity.Category;
import com.example.petshopproject.entity.ProductComment;
import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDto {
    private String name;
    private String description;
    private int price;
    @Lob
    private byte[] byteImage;
    private MultipartFile image;
    private ProductComment comments;
}
