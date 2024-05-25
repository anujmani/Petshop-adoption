package com.example.petshopproject.dto;

import com.example.petshopproject.entity.User;
import com.example.petshopproject.entity.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.Negative;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
//@AllArgsConstructor
public class PetResponseDto implements Serializable {
    private int petsId;
    private String name;
    private String reason;
    private String petDescription;
    private int age;
    private String color;
    @Enumerated(EnumType.STRING)
    private Type type;
    private byte[] picture;
    private Integer userId;

//    @ManyToOne
//    @JoinColumn(name = "added_by")
//    private User addedBy;
}
