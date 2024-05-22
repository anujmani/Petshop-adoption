package com.example.petshopproject.services;

import com.example.petshopproject.dto.FilterParam;
import com.example.petshopproject.dto.PetResponseDto;
import com.example.petshopproject.dto.PetrequestDto;
import com.example.petshopproject.entity.Pet;
import com.example.petshopproject.entity.User;
import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.repositories.CustomerRepo;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetServiceImpl implements PetService {
    private final ObjectMapper objectMapper;
    private final PetRepo petRepo;
    private final CustomerRepo userRepo;
    private final JwtService jwtService;



    @Override
    public PetResponseDto addNewPets(PetrequestDto petrequestDto, String token) throws IOException {

        String userId=getIdFromToken(token);
        Pet pet = new Pet();
        pet.setName(petrequestDto.getName());
        pet.setAge(petrequestDto.getAge());
        pet.setPetDescription(petrequestDto.getPetDescription());
        pet.setColor(petrequestDto.getColor());
        Optional<User> user = Optional.ofNullable(userRepo.findByName(userId));
        if (user.isPresent()) {
            pet.setAddedBy(user.get());
        }
        pet.setStatus(Status.AVAILABLE);
        pet.setPicture(petrequestDto.getPicture());
        return petRepo.save(pet).getDto();
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
    public String getIdFromToken(String token){

        String userNameStr = jwtService.getUserNameFromToken(token);
        System.out.println(userNameStr);

        return userNameStr;

    }
}