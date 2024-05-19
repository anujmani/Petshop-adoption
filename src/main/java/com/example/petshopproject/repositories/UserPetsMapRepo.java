package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.UserPetsMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPetsMapRepo extends JpaRepository<UserPetsMap,Long> {
}
