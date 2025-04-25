package com.example.ProductManagement.service.impl;

import com.example.ProductManagement.dto.UserDetailsDto;
import com.example.ProductManagement.dto.UserDto;
import com.example.ProductManagement.entity.Product;
import com.example.ProductManagement.entity.User;
import com.example.ProductManagement.exception.ResourceNotFoundException;
import com.example.ProductManagement.exception.UserAlreadyExistsException;
import com.example.ProductManagement.mapper.UserMapper;
import com.example.ProductManagement.repository.ProductRepository;
import com.example.ProductManagement.repository.UserRepository;
import com.example.ProductManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Override
    public UserDto createAccount(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        Optional<User> optionalUser = userRepository.findByName(user.getName());
        if(optionalUser.isPresent()){
            throw new UserAlreadyExistsException("Unable to create the user account, it is already existed: " + user.getName());
        }

        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public void deleteAccount(String name) {
        userRepository.findByName(name).orElseThrow(() ->
                new ResourceNotFoundException("Unable to delete the user, not existed with the given name: " + name));

        userRepository.deleteByName(name);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((element) -> UserMapper.mapToUserDto(element)).collect(Collectors.toList());
    }

    @Override
    public UserDetailsDto getAccountDetails(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to get the user details, not existed with the given name: " + name));

        List<Product> productList = productRepository.findByOwnerName(name);

        UserDetailsDto dto = new UserDetailsDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setProductList(productList);
        return dto;
    }

}