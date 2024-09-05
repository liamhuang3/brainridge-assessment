package com.example.brainridgeassessment.service;

import com.example.brainridgeassessment.dto.UserCreateDTO;
import com.example.brainridgeassessment.model.User;
import com.example.brainridgeassessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> createUser(UserCreateDTO userCreateDTO) {
        if (userCreateDTO.getBalance() >= 0) {
            User newUser = new User(userRepository.getNextId(), userCreateDTO.getBalance());
            userRepository.save(newUser);
            return ResponseEntity.ok("User created with id: " + newUser.getId());
        } else {
            return ResponseEntity.badRequest().body("Balance cannot be negative");
        }
    }


}
