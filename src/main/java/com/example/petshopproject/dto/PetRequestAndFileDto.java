package com.example.petshopproject.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PetRequestAndFileDto {
    private PetrequestDto petrequestDto;
    private MultipartFile picture;
}
