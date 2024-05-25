package com.example.petshopproject.controller;



import com.example.petshopproject.dto.FilterParam;
import com.example.petshopproject.dto.ProductDto;
import com.example.petshopproject.dto.ProductFilterParam;
import com.example.petshopproject.entity.Product;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Filter;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/create")
    public Product createProduct(@ModelAttribute ProductDto product,@RequestHeader("Authorization") String token) throws ResourceNotFoundException, IOException {
        Product createdProduct = productService.addProduct(product,token);
        System.out.println(token);
        if(createdProduct == null){
            throw new ResourceNotFoundException("Error creating product.");
        }
        return createdProduct;
    }

    @GetMapping("/getProductsList")
    public List<Product> getAllProducts(ProductFilterParam filterParam) throws ResourceNotFoundException {
        List<Product> products = productService.getAllProduct(filterParam);
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
