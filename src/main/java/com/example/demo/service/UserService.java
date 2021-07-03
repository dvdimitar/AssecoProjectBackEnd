package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User findById(Long userId);
    User registerUser(User user);
    UserDetails loadUserByUsername(String username);
}
