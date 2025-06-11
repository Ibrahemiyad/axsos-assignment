package com.example.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.example.login.models.User;
import com.example.login.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    public User register(User newUser, BindingResult result) {
        // Add registration logic here (e.g., validation, checking for existing users)
        return userRepo.save(newUser);
    }

    public User login(LoginUser newLogin, BindingResult result) {
        // Add login logic here (e.g., checking credentials)
        return userRepo.findByUsername(newLogin.getUsername())
                       .filter(user -> user.getPassword().equals(newLogin.getPassword()))
                       .orElse(null);
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.orElse(null);
    }
}