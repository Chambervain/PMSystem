package com.example.ProductManagement.dto;

import com.example.ProductManagement.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

    private String name;

    private String email;

    private String role;

    private List<Product> productList;

}