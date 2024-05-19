package com.example.petshopproject.dto;

import com.example.petshopproject.entity.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Negative;
import lombok.*;

import java.io.Serializable;

@Data
public class PetrequestDto implements Serializable {
    private String name;
    private String reason;
    private String petDescription;
    private int age;
    private String color;
    @Enumerated(EnumType.STRING)
    private Type type;
}
