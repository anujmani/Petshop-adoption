package com.example.petshopproject.services;

import com.example.petshopproject.entity.User;
import com.example.petshopproject.entity.enums.Roles;
import com.example.petshopproject.repositories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {

        User userUser = customerRepo.findByName(user.getUsername());
        if (userUser !=null) {
            System.out.println("There is already a user present");
            throw new RuntimeException("There is already a user named this");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(Roles.USER);
            userUser = customerRepo.save(user);
        }
        return userUser;
    }

    public Optional<User> getbyUserName(String name) {
        Optional<User> customer= Optional.ofNullable(customerRepo.findByName(name));
        System.out.println(customer.get().getName());
        return customer;
    }

    @Override
    public void createAdminAccount(User user) {
        User userUser = customerRepo.findByName(user.getUsername());
        if (userUser !=null) {
            System.out.println("There is already a user present");
            throw new RuntimeException("There is already a user named this");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(Roles.ADMIN);
            customerRepo.save(user);
        }

    }
}

