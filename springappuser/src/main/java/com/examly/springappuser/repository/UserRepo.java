package com.examly.springappuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springappuser.model.User;

public interface UserRepo extends JpaRepository<User,Long>{

     Optional<User> findByEmail(String email);
} 
