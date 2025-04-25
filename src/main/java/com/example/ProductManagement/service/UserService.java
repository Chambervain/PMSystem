package com.example.ProductManagement.service;

import com.example.ProductManagement.dto.UserDetailsDto;
import com.example.ProductManagement.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createAccount(UserDto userDto);

    void deleteAccount(String name);

    List<UserDto> getAllUsers();

    UserDetailsDto getAccountDetails(String name);

}
