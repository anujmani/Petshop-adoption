package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.UserProductMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProductMapRepo extends JpaRepository<UserProductMap,Long> {
    @Query("select upm from UserProductMap upm order by upm.product.category.name asc ")
    List<UserProductMap> getByCategory();
}
