package com.example.petshopproject.entity;

import com.example.petshopproject.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private Integer productId;

    @Column(name = "product_Name", nullable = false)
    private String productName;

    @Column(name = "product_Description", nullable = false)
    private String productDescription;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "image", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] image;

    @Column(name = "created", columnDefinition = "datetime default CURRENT_TIMESTAMP", nullable = false)
    private Date createdDate;

    private Status status;
    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<PetComment> petComments = new ArrayList<>();
}
