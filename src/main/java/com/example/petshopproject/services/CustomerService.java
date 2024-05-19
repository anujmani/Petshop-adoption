package com.example.petshopproject.services;

import com.example.petshopproject.entity.User;

import java.util.Optional;

public interface CustomerService {
    User createUser(User user);

    Optional<User> getbyUserName(String username);

    public void createAdminAccount(User user);
}
