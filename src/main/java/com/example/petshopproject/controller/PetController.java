package com.example.petshopproject.controller;

import com.example.petshopproject.dto.FilterParam;
import com.example.petshopproject.dto.PetRequestAndFileDto;
import com.example.petshopproject.dto.PetResponseDto;
import com.example.petshopproject.dto.PetrequestDto;
import com.example.petshopproject.entity.Pet;
import com.example.petshopproject.repositories.PetRepo;
import com.example.petshopproject.services.PetService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin("*")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    @PostMapping("/create")
    private String addNewPets(@RequestPart("picture") MultipartFile file,@RequestPart("petrequestDto")PetrequestDto petrequestDto ) throws IOException {
        return petService.addNewPets(file,petrequestDto);
    }
    @GetMapping("/getPetsList")
    private Page<PetResponseDto> petsList(FilterParam filterParam){
        return petService.getAllpets(filterParam);
    }
    @GetMapping("/getPetsById/{id}")
    private ResponseEntity<PetResponseDto> getPet(@PathVariable("id") int id){
        return ResponseEntity.ok(petService.getPetsById(id));
    }
    @DeleteMapping("/delete/{id}")
    private String deletePets(@PathVariable("id") int id){
        return petService.deletePets(id);
    }
}
