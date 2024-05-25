package com.example.petshopproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterParam {
  private String name;
  private String description;
  private int price;
  private int age;
  private String color;
}
