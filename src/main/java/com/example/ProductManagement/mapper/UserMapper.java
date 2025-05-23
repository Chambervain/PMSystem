package com.example.ProductManagement.mapper;

import com.example.ProductManagement.dto.UserDto;
import com.example.ProductManagement.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(user.getName(), user.getPassword(), user.getEmail(), user.getRole());
    }

    public static User mapToUser(UserDto userDto){
        return new User(userDto.getName(), userDto.getPassword(), userDto.getEmail(), userDto.getRole());
    }

}