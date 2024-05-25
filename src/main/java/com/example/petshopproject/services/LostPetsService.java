package com.example.petshopproject.services;

import com.example.petshopproject.dto.LostPetsDto;
import com.example.petshopproject.entity.LostPets;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface LostPetsService {
    List<LostPets> findAll();

    Optional<LostPets> findById(Long id);

    LostPets save(LostPetsDto lostPet) throws IOException;

    LostPets update(Long id, LostPets updatedLostPet);
}
