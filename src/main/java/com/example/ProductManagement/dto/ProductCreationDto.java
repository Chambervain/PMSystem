package com.example.ProductManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreationDto {

    private long id;

    private String name;

    private int quantity;

    private String description;

    private String owner;

}