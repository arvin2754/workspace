package com.examly.springappuser.controller;


import com.examly.springappuser.model.LoginDTO;
import com.examly.springappuser.model.User;
import com.examly.springappuser.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private com.examly.springappuser.config.JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.register(user);
            return ResponseEntity.status(201).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed");
        }
    }

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody User user) {
    Optional<User> optionalUser = userService.findByEmail(user.getEmail());

    if (optionalUser.isEmpty()) {
        return ResponseEntity.badRequest().body("Invalid email");
    }

    User existingUser = optionalUser.get();

    // Safe null-check and password comparison
    if (!existingUser.getPassword().equals(user.getPassword())) {
        return ResponseEntity.badRequest().body("Invalid password");
    }

    // Generate JWT token
    String token = jwtUtil.generateToken(existingUser.getEmail());

    LoginDTO response = new LoginDTO(
            token,
            existingUser.getUsername(),
            existingUser.getUserRole(),
            existingUser.getUserId()
    );

    return ResponseEntity.ok(response);
}
}

