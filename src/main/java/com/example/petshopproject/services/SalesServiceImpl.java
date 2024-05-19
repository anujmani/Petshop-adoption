package com.example.petshopproject.services;

import com.example.petshopproject.entity.UserProductMap;
import com.example.petshopproject.repositories.UserProductMapRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService{
    private final UserProductMapRepo userProductMapRepo;
    @Override
    public void createSales(List<UserProductMap >userProductMap) {

        userProductMap.forEach(userProductMap1 -> userProductMapRepo.save(userProductMap1));
    }

    @Override
    public List<UserProductMap> getAllUserProductMap() {
        List<UserProductMap> userProductMaps=userProductMapRepo.getByCategory();
        return userProductMaps;
    }

}
