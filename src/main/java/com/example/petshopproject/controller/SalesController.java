package com.example.petshopproject.controller;

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
    public void userProductMap(@RequestBody List<UserProductMap> userProductMap){
        salesService.createSales(userProductMap);
    }

    @GetMapping("/getAllSales")
    public List<UserProductMap> getUserProductMap(){
        return salesService.getAllUserProductMap();
    }

}
