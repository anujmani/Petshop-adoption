package com.example.petshopproject.repositories;

import com.example.petshopproject.entity.UserPetsMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPetsMapRepo extends JpaRepository<UserPetsMap,Long> {
    @Query("select upt from UserPetsMap upt where upt.user.name=:userId")
    List<UserPetsMap> getByUserName(String userId);
}
