package com.example.petshopproject.dto;

import com.example.petshopproject.entity.enums.Type;
import jakarta.persistence.*;
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
    private byte[] picture;
    private Integer userId;

//    @ManyToOne
//    @JoinColumn(name = "added_by")
//    private User addedBy;
}
