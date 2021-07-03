package com.example.demo.service.impl;

import com.example.demo.model.Roles;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public AuthServiceImpl(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }


    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public Long getCurrentUserId() {
        return this.getCurrentUser().getId();
    }

    @Override
    public User signUpUser(User user) {
        if(!user.getPassword().equals(user.getRepeatedPassword())){
            throw new IllegalArgumentException();
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        String password = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(password);
        Roles userRole = this.roleRepository.findByName("ROLE_USER");
        newUser.setRoles(Collections.singletonList(userRole));
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setRepeatedPassword(password);
        return this.userService.registerUser(newUser);
    }

}
