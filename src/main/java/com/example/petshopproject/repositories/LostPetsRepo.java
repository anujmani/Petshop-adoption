package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.LostPets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostPetsRepo extends JpaRepository<LostPets,Long> {
}
