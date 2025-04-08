package com.example.ProductManagement.service.impl;

import com.example.ProductManagement.dto.UserDto;
import com.example.ProductManagement.entity.User;
import com.example.ProductManagement.exception.ResourceNotFoundException;
import com.example.ProductManagement.mapper.UserMapper;
import com.example.ProductManagement.repository.UserRepository;
import com.example.ProductManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createAccount(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public void deleteAccount(String name) {
        userRepository.findByName(name).orElseThrow(() ->
                new ResourceNotFoundException("Unable to delete the user, not existed with the given name: " + name));

        userRepository.deleteByName(name);
    }

}