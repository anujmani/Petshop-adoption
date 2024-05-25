package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.PetComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetCommentRepo extends JpaRepository<PetComment, Integer> {
    List<PetComment> getByPetId(Long id);
    // Add custom query methods if needed
}