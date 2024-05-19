package com.example.petshopproject.controller;

import com.example.petshopproject.entity.UserPetsMap;
import com.example.petshopproject.services.AdoptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adopt")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserPetsMapController {
    private final AdoptService adoptService;
    @PostMapping("/adopt")
    public ResponseEntity<UserPetsMap> userProductMap(@RequestBody UserPetsMap userPetsMap){
        return ResponseEntity.ok(adoptService.createAdoption(userPetsMap));
    }

}
