package com.example.petshopproject.entity;

import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.entity.enums.Type;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pet_id")
    private int petsId;
    private String petDescription;
    private int age;
    private String color;
    private String name;
    private String reason;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "Image", nullable = false)
    private String picture;

}
