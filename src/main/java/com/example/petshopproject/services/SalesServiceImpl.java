package com.example.petshopproject.services;

import com.example.petshopproject.dto.OrderDto;
import com.example.petshopproject.dto.UserPetsMapsDto;
import com.example.petshopproject.entity.*;
import com.example.petshopproject.entity.enums.Status;
import com.example.petshopproject.exception.ResourceNotFoundException;
import com.example.petshopproject.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService {
    private final CustomerRepo userRepo;
    private final UserProductMapRepo userProductMapRepo;
    private final ProductRepo productRepo;
    private final UserPetsMapRepo userPetsMapRepo;
    private final JwtService jwtService;
    private final PetRepo petRepo;

    @Override
    public void createSales(UserPetsMapsDto userProductMap) {
        List<UserProductMap> userProductMaps = new ArrayList<>();

        for (int petId : userProductMap.getItems()) {
            UserProductMap userPetsMap = new UserProductMap();
            userPetsMap.setUser(userRepo.findByName(userProductMap.getUser()));
            Optional<Product> product = productRepo.findById(petId);

            if (product.isPresent()) {
                Product productSale = product.get();
                if (productSale.getStatus().equals(Status.AVAILABLE)) {
                    userPetsMap.setProduct(productSale);
                    userPetsMap.setSaleDay(new Date());
                    productSale.setStatus(Status.SOLD);
                    userPetsMap.setMblNo(userProductMap.getMblNo());
                    userPetsMap.setDeliveryAddress(userPetsMap.getDeliveryAddress());
                    productRepo.save(productSale);
                    userProductMaps.add(userProductMapRepo.save(userPetsMap));
                } else {
                    throw new RuntimeException("Product with ID " + petId + " is not available for adoption");
                }
            } else {
                throw new ResourceNotFoundException("Product with ID " + petId + " not found");
            }
        }
    }

    @Override
    public List<OrderDto> getAllUserProductMap(String token) {
        String userId = getIdFromToken(token);
        List<Product> productList = productRepo.getByUserName(userId);

        // Map UserProductMap entities to OrderDto objects
        List<OrderDto> orderDtos = productList.stream()
                .map(this::mapUserProductMapToOrderDto)
                .collect(Collectors.toList());
        List<Pet> userPetsMaps = petRepo.getByUserName(userId);
        orderDtos.addAll(userPetsMaps.stream()
                .map(this::mapUserPetMapToOrderDto)
                .collect(Collectors.toList()));
        System.out.println(orderDtos);

        return orderDtos;
    }

    // Helper method to map UserProductMap entity to OrderDto object
    private OrderDto mapUserProductMapToOrderDto(Product userProductMap) {
        OrderDto orderDto = new OrderDto();
        orderDto.setName(userProductMap.getProductName()); // Assuming UserProductMap has an ID
        orderDto.setDescription(userProductMap.getProductDescription()); // Assuming Product has a name field
        orderDto.setStatus(userProductMap.getStatus().name());// Assuming User has an ID
        // Set other fields as needed

        return orderDto;
    }

    private OrderDto mapUserPetMapToOrderDto(Pet userPetsMap) {
        OrderDto orderDto = new OrderDto();
        orderDto.setName(userPetsMap.getName()); // Assuming UserProductMap has an ID
        orderDto.setStatus(userPetsMap.getStatus().name()); // Assuming Product has a name field
        orderDto.setDescription(userPetsMap.getPetDescription());// Assuming User has an ID

        // Set other fields as needed

        return orderDto;
    }

    public String getIdFromToken(String token) {

        String userNameStr = jwtService.getUserNameFromToken(token);
        System.out.println(userNameStr);

        return userNameStr;

    }

}
