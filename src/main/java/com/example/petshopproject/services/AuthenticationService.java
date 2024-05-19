package com.example.petshopproject.services;

import com.example.petshopproject.dto.AuthenticationRequest;
import com.example.petshopproject.dto.AuthenticationResponse;
import com.example.petshopproject.repositories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CustomerRepo repo;
    private final JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;



    public AuthenticationResponse authenticate(AuthenticationRequest request){
        System.out.print("This is not working");
        System.out.println(request.getName());
        System.out.println(request.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getName(),
                    request.getPassword()
            ));
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("why is this not working");
        var user= repo.findByName(request.getName());
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}