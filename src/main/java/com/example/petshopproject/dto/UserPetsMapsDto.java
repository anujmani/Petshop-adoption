package com.example.petshopproject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserPetsMapsDto {
    @NotNull
    private List<Integer> items;
    @NotNull
    private String user;
    @NotNull
    private double mblNo;
    private String address;
}
