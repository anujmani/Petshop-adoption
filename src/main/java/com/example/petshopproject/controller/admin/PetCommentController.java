package com.example.petshopproject.controller.admin;

import com.example.petshopproject.entity.PetComment;
import com.example.petshopproject.services.PetCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class PetCommentController {

    private final PetCommentService petCommentService;

    @Autowired
    public PetCommentController(PetCommentService petCommentService) {
        this.petCommentService = petCommentService;
    }

    @PostMapping("save")
    public ResponseEntity<PetComment> addPetComment(@RequestBody PetComment petComment,@RequestHeader("Authorization") String token) {
        PetComment savedPetComment = petCommentService.savePetComment(petComment,token);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPetComment);
    }

    @GetMapping("/get/{id}")
    public List<PetComment> getAllCommentsByPetId(@PathVariable Long id) {
        return petCommentService.getByPetId(id);
    }
}