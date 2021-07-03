package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long userId) {
        return this.userRepository.findById(userId).
                orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User registerUser(User user) {
        if (this.userRepository.existsByName(user.getUsername())){
            throw new IllegalArgumentException();
        }
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
            User user = this.userRepository.findByUsername(username);
            if (user == null){
                throw new UsernameNotFoundException(username);
            }
            return this.userRepository.findById(user.getId())
                    .orElseThrow(() -> new UsernameNotFoundException(username));
        }

}
