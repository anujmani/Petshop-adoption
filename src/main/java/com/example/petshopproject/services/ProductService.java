package com.example.petshopproject.services;

import com.example.petshopproject.dto.ProductDto;
import com.example.petshopproject.entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDto product);
    List<Product> getAllProduct();

    Product findProductById(int productId);
}
