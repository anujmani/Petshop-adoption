package com.example.petshopproject.services;

import com.example.petshopproject.dto.FilterParam;
import com.example.petshopproject.dto.ProductDto;
import com.example.petshopproject.dto.ProductFilterParam;
import com.example.petshopproject.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product addProduct(ProductDto product, String token) throws IOException;
    List<Product> getAllProduct(ProductFilterParam filterParam);

    Product findProductById(int productId);
}
