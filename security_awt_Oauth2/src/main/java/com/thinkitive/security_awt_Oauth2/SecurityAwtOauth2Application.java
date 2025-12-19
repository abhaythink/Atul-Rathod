package com.thinkitive.security_awt_Oauth2;

import com.thinkitive.security_awt_Oauth2.entity.User;
import com.thinkitive.security_awt_Oauth2.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SecurityAwtOauth2Application {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostConstruct
    public void initUsers() {

        List<User> users = List.of(
                User.builder()
                        .userName("javatechie1")
                        .password(passwordEncoder.encode("password1"))
                        .email("javatechie1@gmail.com")
                        .build(),

                User.builder()
                        .userName("javatechie2")
                        .password(passwordEncoder.encode("password2"))
                        .email("javatechie2@gmail.com")
                        .build(),

                User.builder()
                        .userName("javatechie3")
                        .password(passwordEncoder.encode("password3"))
                        .email("javatechie3@gmail.com")
                        .build()
        );

        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityAwtOauth2Application.class, args);
    }
}
