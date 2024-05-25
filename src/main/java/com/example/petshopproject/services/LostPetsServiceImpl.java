package com.example.petshopproject.services;

import com.example.petshopproject.dto.LostPetsDto;
import com.example.petshopproject.entity.LostPets;
import com.example.petshopproject.repositories.LostPetsRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LostPetsServiceImpl implements LostPetsService {
    @Autowired
    private LostPetsRepo lostPetRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public List<LostPets> findAll() {
        return lostPetRepository.findAll();
    }

    public Optional<LostPets> findById(Long id) {
        return lostPetRepository.findById(id);
    }

    public LostPets save(LostPetsDto lostPet) throws IOException {
        LostPets pets= new LostPets();
        pets.setName(lostPet.getName());
        pets.setDescription(lostPet.getDescription());
        pets.setLocation(lostPet.getLocation());
        pets.setPicture(lostPet.getPicture().getBytes());

        return lostPetRepository.save(pets);
    }

    public LostPets update(Long id, LostPets updatedLostPet) {
        return lostPetRepository.findById(id)
                .map(existingPet -> {
                    existingPet.setName(updatedLostPet.getName());
                    existingPet.setDescription(updatedLostPet.getDescription());
                    existingPet.setLocation(updatedLostPet.getLocation());
                    existingPet.setPicture(updatedLostPet.getPicture());
                    return lostPetRepository.save(existingPet);
                })
                .orElseThrow(() -> new RuntimeException("Lost pet not found with id " + id));
    }

}
