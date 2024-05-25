package com.example.petshopproject.services;

import com.example.petshopproject.entity.PetComment;
import com.example.petshopproject.repositories.PetCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PetCommentService {

    PetComment savePetComment(PetComment petComment,String token);

    List<PetComment> getByPetId(Long id);
}
