package com.example.petshopproject.services;

import com.example.petshopproject.entity.Pet;
import com.example.petshopproject.entity.PetComment;
import com.example.petshopproject.repositories.PetCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class petCommentServiceImple implements PetCommentService {
    @Autowired
    private PetCommentRepo petCommentRepo;
    @Autowired
    private JwtService jwtService;
    public PetComment savePetComment(PetComment petComment,String token) {
        String userId = getIdFromToken(token);
        petComment.setCommentedBy(userId);
        return petCommentRepo.save(petComment);
    }

    public List<PetComment> getByPetId(Long id) {
        List<PetComment> petCommentsById= petCommentRepo.getByPetId(id);
        return petCommentsById;
    }

    public String getIdFromToken(String token) {

        String userNameStr = jwtService.getUserNameFromToken(token);
        System.out.println(userNameStr);

        return userNameStr;

    }
}
