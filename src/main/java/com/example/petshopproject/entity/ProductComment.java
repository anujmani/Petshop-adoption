package com.example.petshopproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name = "product_comment")
public class ProductComment implements Serializable {

    @Id
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment_by")
    private String commentedBy;

    @Column(name = "comment")
    private String comment;

}
