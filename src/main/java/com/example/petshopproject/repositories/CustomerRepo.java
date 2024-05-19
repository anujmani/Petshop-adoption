package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<User,Integer> {
    User findByName(String custName);
}
