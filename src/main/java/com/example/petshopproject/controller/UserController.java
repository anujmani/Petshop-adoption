package com.example.petshopproject.controller;

import com.example.petshopproject.dto.AuthenticationRequest;
import com.example.petshopproject.dto.AuthenticationResponse;
import com.example.petshopproject.entity.User;
import com.example.petshopproject.services.AuthenticationService;
import com.example.petshopproject.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuthenticationService service;
    @Autowired
    private UserDetailsService userDetailsService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("Adding new Customer");
        return ResponseEntity.ok(customerService.createUser(user));

    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{username}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("username") String username) {
        logger.info("Fetching customer");
        return ResponseEntity.ok(customerService.getbyUserName(username));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{admin}")
    public ResponseEntity<Optional<User>> getAdmin(@PathVariable("username") String username) {
        logger.info("Fetching customer");
        return ResponseEntity.ok(customerService.getbyUserName(username));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println(request.getName());
        System.out.println(service.authenticate(request));
        return ResponseEntity.ok(service.authenticate(request));
    }
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        logger.info("wqorks");
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}