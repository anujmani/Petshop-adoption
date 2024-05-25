package com.example.petshopproject.services;

import com.example.petshopproject.dto.ProductDto;
import com.example.petshopproject.dto.ProductFilterParam;
import com.example.petshopproject.entity.Product;
import com.example.petshopproject.entity.User;
import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.repositories.CustomerRepo;
import com.example.petshopproject.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private JwtService jwtService;
    @Override
    public Product addProduct(ProductDto product, String token) throws IOException {
        Product product1= new Product();
        String userId=getIdFromToken(token);
        product1.setProductName(product.getName());
        product1.setProductDescription(product.getDescription());
        product1.setImage(product.getPicture().getBytes());
        product1.setPrice(product.getPrice());
        Optional<User> user = Optional.ofNullable(customerRepo.findByName(userId));
        if (user.isPresent()) {
            product1.setUser(user.get());
        }
        product1.setStatus(Status.AVAILABLE);
        product1.setCreatedDate(new Date());


        product1.setPetComments(new ArrayList<>());
       return productRepo.save(product1);
    }

    public String getIdFromToken(String token){

        String userNameStr = jwtService.getUserNameFromToken(token);
        System.out.println(userNameStr);

        return userNameStr;

    }

    @Override
    public List<Product> getAllProduct(ProductFilterParam filterParam) {

        List<Product> products=productRepo.findAll();
        return products;
    }

    @Override
    public Product findProductById(int productId) {
        Product product= productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product not found"));
        return product;
    }
}
