package com.example.petshopproject.services;

import com.example.petshopproject.dto.UserPetsMapsDto;
import com.example.petshopproject.entity.Pet;
import com.example.petshopproject.entity.UserPetsMap;
import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.repositories.CustomerRepo;
import com.example.petshopproject.repositories.PetRepo;
import com.example.petshopproject.repositories.UserPetsMapRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AdoptServiceImpl implements AdoptService {
    private final UserPetsMapRepo userPetsMapRepo;
    private final CustomerRepo userRepo;
    private final PetRepo petRepo;


    @Override
    public List<UserPetsMap> createAdoption(UserPetsMapsDto userPetsMapsDto) {
        List<UserPetsMap> userPetsMaps = new ArrayList<>();

        for (int petId : userPetsMapsDto.getItems()) {
            UserPetsMap userPetsMap = new UserPetsMap();
            userPetsMap.setUser(userRepo.findByName(userPetsMapsDto.getUser()));
            Optional<Pet> pet = petRepo.findById(petId);

            if (pet.isPresent()) {
                Pet adoptingPet = pet.get();
                if (adoptingPet.getStatus().equals(Status.AVAILABLE)) {
                    userPetsMap.setPet(adoptingPet);
                    userPetsMap.setAdoptionDay(new Date());
                    adoptingPet.setStatus(Status.ADOPTED);
                    userPetsMap.setMblNo(userPetsMapsDto.getMblNo());
                    userPetsMap.setDeliveryAddress(userPetsMap.getDeliveryAddress());
                    petRepo.save(adoptingPet);
                    userPetsMaps.add(userPetsMapRepo.save(userPetsMap));
                } else {
                    throw new RuntimeException("Pet with ID " + petId + " is not available for adoption");
                }
            } else {
                throw new ResourceNotFoundException("Pet with ID " + petId + " not found");
            }
        }

        return userPetsMaps;
    }


}
