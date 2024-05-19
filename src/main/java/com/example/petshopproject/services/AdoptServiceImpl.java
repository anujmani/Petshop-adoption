package com.example.petshopproject.services;

import com.example.petshopproject.entity.UserPetsMap;
import com.example.petshopproject.repositories.UserPetsMapRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Service
@RequiredArgsConstructor

public class AdoptServiceImpl implements AdoptService {
    private final UserPetsMapRepo userPetsMapRepo ;


    @Override
    public UserPetsMap createAdoption(UserPetsMap userPetsMap) {
        userPetsMap.setAdoptionDay(new Date());
        return userPetsMapRepo.save(userPetsMap);
    }
}
