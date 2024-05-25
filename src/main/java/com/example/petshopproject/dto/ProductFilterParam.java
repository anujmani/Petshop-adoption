package com.example.petshopproject.dto;

import lombok.Data;

@Data
public class ProductFilterParam {
    private String name;
    private String description;
    private int price;
}
