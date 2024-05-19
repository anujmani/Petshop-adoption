package com.example.petshopproject.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class AuthenticationResponse {
    private String token;
}
