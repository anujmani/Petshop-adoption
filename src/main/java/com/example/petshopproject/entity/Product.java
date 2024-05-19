package com.example.petshopproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

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
    private Date created;

    @Column(name = "modified", columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date modified;

    @Column(name = "deleted", columnDefinition = "tinyint default 0")
    private Boolean deleted;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private Category category;
    @ManyToOne
    private User user;
}
