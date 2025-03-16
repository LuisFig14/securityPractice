package com.practice.security.controller;

import com.practice.security.dto.user.AuthRequest;
import com.practice.security.dto.user.UserDto;
import com.practice.security.entity.user.UserEntity;
import com.practice.security.repository.UserRepository;
import com.practice.security.service.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthService authService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }

    //Register user
    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto){

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()){
            return "the user exists";
        }

        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());

        userRepository.save(user);
        return "user created successfully";

    }

    //Login

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody AuthRequest authRequest){

        String token = authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok(token);

    }





}
