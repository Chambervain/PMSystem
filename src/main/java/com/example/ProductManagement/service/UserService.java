package com.example.ProductManagement.service;

import com.example.ProductManagement.dto.UserDetailsDto;
import com.example.ProductManagement.dto.UserDto;

public interface UserService {

    UserDto createAccount(UserDto userDto);

    void deleteAccount(String name);

    UserDetailsDto getAccountDetails(String name);

}
