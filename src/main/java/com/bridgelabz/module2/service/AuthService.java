package com.bridgelabz.module2.service;

import com.bridgelabz.module2.dto.LoginRequest;
import com.bridgelabz.module2.dto.LoginResponse;
import com.bridgelabz.module2.entity.User;
import com.bridgelabz.module2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {

        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isEmpty()) {
            return new LoginResponse("User not found");
        }

        User user = userOptional.get();

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return new LoginResponse("Invalid password");
        }

        return new LoginResponse("Login successful");
    }
}