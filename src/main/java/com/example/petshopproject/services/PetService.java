package com.example.petshopproject.services;

import com.example.petshopproject.dto.FilterParam;
import com.example.petshopproject.dto.PetRequestAndFileDto;
import com.example.petshopproject.dto.PetResponseDto;
import com.example.petshopproject.dto.PetrequestDto;
import com.example.petshopproject.entity.Pet;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

public interface PetService
{
    PetResponseDto addNewPets(PetrequestDto petrequestDto, String token) throws IOException;

    //    @PreAuthorize("hasRole('ADMIN')")
//    @CacheEvict(value = "PetsCache")
//    String addNewPets(PetrequestDto petrequestDto, MultipartFile file) throws IOException;

    List<PetResponseDto> getAllpets(FilterParam filterParam);

    PetResponseDto getPetsById(int id);


    String deletePets(int id);
}
