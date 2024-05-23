package com.example.petshopproject.services;

import com.example.petshopproject.dto.UserPetsMapsDto;
import com.example.petshopproject.entity.UserPetsMap;

import java.util.List;

public interface AdoptService {
    List<UserPetsMap> createAdoption(UserPetsMapsDto userPetsMap);
}
