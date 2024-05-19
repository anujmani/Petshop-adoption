package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
