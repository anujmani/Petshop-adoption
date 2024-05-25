package com.example.petshopproject.controller;
import com.example.petshopproject.dto.LostPetsDto;
import com.example.petshopproject.dto.PetrequestDto;
import com.example.petshopproject.entity.LostPets;
import com.example.petshopproject.services.LostPetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/lost-pets")
@CrossOrigin("*")
public class LostPetController {

    @Autowired
    private LostPetsService lostPetService;

    @GetMapping
    public List<LostPets> getAllLostPets() {
        return lostPetService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LostPets> getLostPetById(@PathVariable Long id) {
        return lostPetService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public LostPets createLostPet(@ModelAttribute LostPetsDto lostPet) throws IOException {
        return lostPetService.save(lostPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LostPets> updateLostPet(@PathVariable Long id, @RequestBody LostPets lostPet) {
        return ResponseEntity.ok(lostPetService.update(id, lostPet));
    }


}
