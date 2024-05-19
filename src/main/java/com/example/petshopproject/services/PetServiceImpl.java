package com.example.petshopproject.services;

import com.example.petshopproject.dto.FilterParam;
import com.example.petshopproject.dto.PetResponseDto;
import com.example.petshopproject.dto.PetrequestDto;
import com.example.petshopproject.entity.Pet;
import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.repositories.PetRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetServiceImpl implements PetService {
    private final ObjectMapper objectMapper;
    private final PetRepo petRepo;

    private static String FOLDER_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\petpasalBackend\\PetshopBackendDemo" +
            "\\src" +
            "\\main\\resources\\images\\";


    @Override
    public String addNewPets(MultipartFile file, PetrequestDto petrequestDto) throws IOException {

        String filePath = FOLDER_PATH + file.getOriginalFilename();
        Pet pet = objectMapper.convertValue(petrequestDto, Pet.class);
        file.transferTo(new File(filePath));
        pet.setPicture(file.getOriginalFilename());
        pet.setStatus(Status.AVAILABLE);
        if (pet != null) {
            petRepo.save(pet);
            return "file uploaded successfully : " + filePath;
        }
        return "Pet is saved";
    }


    public Page<PetResponseDto> getAllpets(FilterParam filterParam) {
        PageRequest pageRequest = PageRequest.of(filterParam.getPageNumber(), filterParam.getPageSize());
        Page<Pet> petsPage = petRepo.findAll(pageRequest);
        return petsPage.map(pet -> objectMapper.convertValue(pet, PetResponseDto.class));
    }

    @Override
    public PetResponseDto getPetsById(int id) {
        Pet pet = petRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No message"));
        PetResponseDto petResponseDto = objectMapper.convertValue(pet, PetResponseDto.class);

        return petResponseDto;
    }

    @Override
    public String deletePets(int id) {
        petRepo.deletePetByPetsId(id);
        return "Deleted";
    }
}