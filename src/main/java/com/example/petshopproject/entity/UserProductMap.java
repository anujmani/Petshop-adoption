package com.example.petshopproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class UserProductMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name="productId",nullable = false,referencedColumnName = "product_Id")
    @ManyToOne
    private Product product;

    @JoinColumn(name="users",nullable = false,referencedColumnName = "user_id")
    @ManyToOne
    private User user;
    @Column(name = "sale_day", columnDefinition = "datetime default CURRENT_TIMESTAMP", nullable = false)
    private Date saleDay;
}
