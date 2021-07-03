package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = {"/signup"},
        produces = MediaType.APPLICATION_JSON_VALUE)

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public void signUpUser(@RequestBody User user) {
            this.authService.signUpUser(user);
    }
}
