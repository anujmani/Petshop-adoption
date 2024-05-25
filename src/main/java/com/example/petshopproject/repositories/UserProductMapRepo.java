package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.UserProductMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProductMapRepo extends JpaRepository<UserProductMap,Long> {
    @Query("SELECT upmr FROM UserProductMap upmr where upmr.user.name= :userName ")
    List<UserProductMap> getByUserName(String userName);
}
