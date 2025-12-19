package com.thinkitive.security_awt_Oauth2.dto;
import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
