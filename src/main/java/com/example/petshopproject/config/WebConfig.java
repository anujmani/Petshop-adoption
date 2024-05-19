package com.example.petshopproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer {

 
    private static final String FOLDER_PATH = "C:\\\\Users\\\\Lenovo\\\\OneDrive\\\\Desktop\\\\petpasalBackend" +
            "\\\\PetshopBackendDemo\\\\src\" +\n" +
            "            \"\\\\main\\\\resources\\\\images";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + FOLDER_PATH + "/");
    }
}
