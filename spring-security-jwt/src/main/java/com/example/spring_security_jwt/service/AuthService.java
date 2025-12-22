package com.example.spring_security_jwt.service;

import com.example.spring_security_jwt.dto.UserCreatedResponse;
import com.example.spring_security_jwt.dto.UserRequestDto;
import com.example.spring_security_jwt.dto.UserResponseDto;
import com.example.spring_security_jwt.repo.UserRepo;
import com.example.spring_security_jwt.security.SecurityUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.spring_security_jwt.entity.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final SecurityUtility securityUtility;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserResponseDto validateUser(UserRequestDto userRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword())
        );
       User user= (User) authentication.getPrincipal();
       return new UserResponseDto(securityUtility.genearateToken(user),user.getId());
    }


    public UserCreatedResponse registerUser(UserRequestDto userRequestDto) {
        Optional<User> user = userRepo.findByUsername(userRequestDto.getUsername());

        if (user.isEmpty()){
            log.warn("User Is not Present Createing user");
            userRepo.save(User.builder().username(userRequestDto.getUsername())
                    .password(bCryptPasswordEncoder.encode(userRequestDto.getPassword()))
                    .build());
            return new UserCreatedResponse("user created",userRequestDto.getUsername());

        }


        return null;
    }
}
