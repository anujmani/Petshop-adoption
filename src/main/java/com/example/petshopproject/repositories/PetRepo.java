package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepo extends JpaRepository<Pet,Integer> {
    Optional<Pet> deletePetByPetsId(int id);
}
