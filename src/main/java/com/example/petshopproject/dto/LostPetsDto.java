package com.example.petshopproject.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class LostPetsDto {
    private String name;
    private String description;
    private String location;
    private byte[] bytePicture;
    private MultipartFile picture;
}
