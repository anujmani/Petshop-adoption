package com.example.petshopproject.dto;

import com.example.petshopproject.entity.PetComment;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDto {
    private String name;
    private String description;
    private int price;
    private byte[] bytePicture;
    private MultipartFile picture;
    private PetComment comments;
}
