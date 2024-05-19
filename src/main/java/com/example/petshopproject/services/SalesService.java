package com.example.petshopproject.services;

import com.example.petshopproject.entity.UserProductMap;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalesService {
    void createSales(List<UserProductMap> userProductMap);

    List<UserProductMap> getAllUserProductMap();
}
