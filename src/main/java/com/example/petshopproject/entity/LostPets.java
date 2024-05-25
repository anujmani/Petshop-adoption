package com.example.petshopproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lost_pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LostPets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String location;
    @Lob
    @Column(name = "pictureUrl", nullable = false, columnDefinition = "longblob")
    private byte[] picture;
}
