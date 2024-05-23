package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.UserProductMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProductMapRepo extends JpaRepository<UserProductMap,Long> {

}
