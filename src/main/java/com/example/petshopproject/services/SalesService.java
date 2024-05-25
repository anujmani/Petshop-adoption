package com.example.petshopproject.services;

import com.example.petshopproject.dto.OrderDto;
import com.example.petshopproject.dto.UserPetsMapsDto;
import com.example.petshopproject.entity.UserProductMap;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalesService {
    void createSales(UserPetsMapsDto userProductMap);

    List<OrderDto> getAllUserProductMap(String token);
}
