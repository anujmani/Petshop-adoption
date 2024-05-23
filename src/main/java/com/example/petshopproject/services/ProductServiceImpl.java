package com.example.petshopproject.services;

import com.example.petshopproject.dto.PetResponseDto;
import com.example.petshopproject.dto.ProductDto;
import com.example.petshopproject.entity.Category;
import com.example.petshopproject.entity.Pet;
import com.example.petshopproject.entity.Product;
import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product addProduct(ProductDto product) {
        Product product1= new Product();
        product1.setProductName(product.getName());
        product1.setProductDescription(product.getDescription());
        product1.setImage(product.getImage());
        product1.setPrice(product.getPrice());
        product1.setStatus(Status.AVAILABLE);

        product1.setProductComments(new ArrayList<>());
       return productRepo.save(product1);
    }

    @Override
    public List<Product> getAllProduct() {

        List<Product> products=productRepo.findAll();
        return products;
    }

    @Override
    public Product findProductById(int productId) {
        Product product= productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product not found"));
        return product;
    }
}
