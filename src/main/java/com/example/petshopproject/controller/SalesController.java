package com.example.petshopproject.controller;

import com.example.petshopproject.dto.OrderDto;
import com.example.petshopproject.dto.UserPetsMapsDto;
import com.example.petshopproject.entity.UserProductMap;
import com.example.petshopproject.services.SalesService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SalesController {
    private final SalesService salesService;
    @PostMapping("/buy")
    public void userProductMap(@RequestBody UserPetsMapsDto userProductMap){
        salesService.createSales(userProductMap);
    }

    @GetMapping("/getAllSales")
    public List<OrderDto> getUserProductMap(@RequestHeader("Authorization") String token){
        return salesService.getAllUserProductMap(token);
    }

}
