package com.example.petshopproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class UserPetsMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name="pets",nullable = false,referencedColumnName = "pet_Id")
    @ManyToOne
    private Pet pet;
    @JoinColumn(name="users",nullable = false,referencedColumnName = "user_id")
    @ManyToOne
    private User user;
    @Column(name = "adoption_day", columnDefinition = "datetime default CURRENT_TIMESTAMP", nullable = false)
    private Date adoptionDay;
    @Column(name="mobile_no", nullable = false)
    private double mblNo;
    @Column(name="delivery_address")
    private String deliveryAddress;
}
