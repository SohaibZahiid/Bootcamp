package com.nutridish.services;

import com.nutridish.dto.UserDTO;
import com.nutridish.entities.UserEntity;
import com.nutridish.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<String> register(UserEntity user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already taken");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is already taken");
        }

        UserEntity registeredUser = userRepository.save(user);
        if (registeredUser == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    public ResponseEntity<UserDTO> login(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            UserDTO mappedUser = modelMapper.map(user, UserDTO.class);
            return ResponseEntity.ok(mappedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
