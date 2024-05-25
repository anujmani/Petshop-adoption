package com.example.petshopproject.entity;

import com.example.petshopproject.dto.PetResponseDto;
import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.entity.enums.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @Lob
    @Column(name = "Image", nullable = false, columnDefinition = "longblob")
    private byte[] picture;
    @ManyToOne
    @JoinColumn(name = "added_by")
    private User addedBy;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private List<PetComment> petComments = new ArrayList<>();

    public PetResponseDto getDto(){
        PetResponseDto petResponseDto= new PetResponseDto();
        petResponseDto.setName(name);
        petResponseDto.setPetDescription(petDescription);
        petResponseDto.setAge(age);
        petResponseDto.setColor(color);
        petResponseDto.setReason(reason);
        petResponseDto.setPicture(picture);
        petResponseDto.setUserId(addedBy.getUserId());
        return petResponseDto;
    }

}
