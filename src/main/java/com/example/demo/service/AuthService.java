package com.example.demo.service;

import com.example.demo.model.User;

public interface AuthService {
    User getCurrentUser();
    Long getCurrentUserId();
    User signUpUser(User user);

}
