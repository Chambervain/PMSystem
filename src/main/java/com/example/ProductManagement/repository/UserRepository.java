package com.example.ProductManagement.repository;

import com.example.ProductManagement.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>{

    Optional<User> findByName(String name);

    @Transactional
    @Modifying
    void deleteByName(String name);

}