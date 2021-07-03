package com.example.demo.web;

import com.example.demo.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(
        value = {"/login"},
        produces = MediaType.APPLICATION_JSON_VALUE)

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

public class LogInController {

    private final AuthService authService;

    public LogInController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public void loginUser(@RequestBody HttpServletRequest req) {
        String username = req.getParameter("username");
        if (username != null) {
            req.getSession().setAttribute("username", username);
        } else {

        }
    }

}
