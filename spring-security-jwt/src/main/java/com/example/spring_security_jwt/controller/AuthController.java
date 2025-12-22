package com.example.spring_security_jwt.controller;

import com.example.spring_security_jwt.dto.UserCreatedResponse;
import com.example.spring_security_jwt.dto.UserRequestDto;
import com.example.spring_security_jwt.dto.UserResponseDto;
import com.example.spring_security_jwt.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/validate")
    public ResponseEntity<UserResponseDto> validateUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(authService.validateUser(userRequestDto));
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDto userRequestDto){
        UserCreatedResponse user = authService.registerUser(userRequestDto);
        if (user!=null)return ResponseEntity.ok(user);
        return ResponseEntity.internalServerError().build();
    }
}
