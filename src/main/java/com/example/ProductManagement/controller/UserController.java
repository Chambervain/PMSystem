package com.example.ProductManagement.controller;

import com.example.ProductManagement.dto.UserDetailsDto;
import com.example.ProductManagement.dto.UserDto;
import com.example.ProductManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createAccount(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteUser(@PathVariable String name) {
        userService.deleteAccount(name);
        return ResponseEntity.ok("The user has been deleted successfully !");
    }

    @GetMapping("/{name}")
    public ResponseEntity<UserDetailsDto> getUserDetails(@PathVariable String name) {
        UserDetailsDto userDetailsDto = userService.getAccountDetails(name);
        return ResponseEntity.ok(userDetailsDto);
    }

}