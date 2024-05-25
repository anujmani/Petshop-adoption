package com.example.petshopproject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDto {
    private String name;
    private String status;
    private String description;
}
