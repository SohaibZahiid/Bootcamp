package com.nutridish.controllers;

import com.nutridish.dto.UserDTO;
import com.nutridish.dto.UserLoginDTO;
import com.nutridish.entities.UserEntity;
import com.nutridish.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@Valid @RequestBody UserEntity user) {
        ResponseEntity<String> response = userService.register(user);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserLoginDTO user) {
        String username = user.getUsername();
        String password = user.getPassword();

        return userService.login(username, password);

    }
}
