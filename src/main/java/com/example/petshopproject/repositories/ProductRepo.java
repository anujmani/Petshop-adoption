package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT p from Product p where p.user.name=:userId")
    List<Product> getByUserName(String userId);
}
