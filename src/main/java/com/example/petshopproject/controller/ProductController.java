package com.example.petshopproject.controller;



import com.example.petshopproject.dto.ProductDto;
import com.example.petshopproject.entity.Product;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody ProductDto product) throws ResourceNotFoundException {
        Product createdProduct = productService.addProduct(product);
        if(createdProduct == null){
            throw new ResourceNotFoundException("Error creating product.");
        }
        return createdProduct;
    }

    @GetMapping("/getall")
    public List<Product> getAllProducts() throws ResourceNotFoundException {
        List<Product> products = productService.getAllProduct();
        if(products == null || products.isEmpty()){
            throw new ResourceNotFoundException("No Products Available");
        }
        return products;
    }

    @GetMapping("/info/{productId}")
    public Product getProductInfo(@PathVariable Integer productId) throws ResourceNotFoundException{
        Product product = productService.findProductById(productId);
        if(product == null){
            throw new ResourceNotFoundException("Product not exists");
        }
        return product;
    }
}
