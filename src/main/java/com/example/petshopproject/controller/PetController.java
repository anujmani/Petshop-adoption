package com.example.petshopproject.controller;

import com.example.petshopproject.dto.FilterParam;
import com.example.petshopproject.dto.PetRequestAndFileDto;
import com.example.petshopproject.dto.PetResponseDto;
import com.example.petshopproject.dto.PetrequestDto;
import com.example.petshopproject.entity.Pet;
import com.example.petshopproject.entity.enums.Type;
import com.example.petshopproject.repositories.PetRepo;
import com.example.petshopproject.services.PetService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.util.Arrays;
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
    //@RequestPart("picture") MultipartFile file,
    private ResponseEntity<PetResponseDto> addNewPets(@ModelAttribute PetrequestDto petrequestDto, @RequestHeader("Authorization") String token) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.addNewPets(petrequestDto,token));
    }
    @PostMapping("/getPetsList")
    private List<PetResponseDto> petsList(@RequestBody FilterParam filterParam){
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

    @GetMapping ("/types")
    private List getTypes(){
        return Arrays.asList(Type.values());
    }
}
