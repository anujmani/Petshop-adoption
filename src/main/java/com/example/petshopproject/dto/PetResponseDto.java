package com.example.petshopproject.dto;

import com.example.petshopproject.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetResponseDto {
    private String name;
    private String reason;
    private String petDescription;
    private int age;

    private String picture;
    private String color;
}
