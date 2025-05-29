package com.examly.springappuser.service;


import java.util.Optional;

import com.examly.springappuser.model.User;

public interface UserService {
    User register(User user);
    Optional<User> findByEmail(String email);
}

