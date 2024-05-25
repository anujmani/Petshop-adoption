package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PetRepo extends JpaRepository<Pet, Integer> {
    Optional<Pet> deletePetByPetsId(int id);

    @Query("select pet from Pet pet where pet.addedBy.name=:userId")
    List<Pet> getByUserName(String userId); @Query("SELECT p FROM Pet p WHERE (:name IS NULL OR p.name = :name) AND (:color IS NULL OR p.color = :color) AND (:age = 0 OR p.age = :age)")
    List<Pet> findByFilter(@Param("name") String name, @Param("color") String color, @Param("age") Integer age);

}
