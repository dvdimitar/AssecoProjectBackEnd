package com.example.demo.model.config;


import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfiguration(UserServiceImpl userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((request)->request.antMatchers("/**").permitAll().anyRequest().authenticated()).httpBasic();
        http.formLogin();
        http.csrf().disable().headers().frameOptions().disable();
            }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}
