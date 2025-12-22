package com.example.spring_security_jwt.security;

import com.example.spring_security_jwt.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class SecurityUtility {

    @Value("${security.key}")
    private  String securityKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(securityKey.getBytes(StandardCharsets.UTF_8));
    }
    
    public String genearateToken(User user){
      return   Jwts.builder().subject(user.getUsername())
                .claim("id ",user.getId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(getSecretKey())
                .compact();
    }


    public String getUsernamefromToken(String bearerToken) {
      Claims claims=  Jwts.parser().verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(bearerToken)
                .getPayload();
      return claims.getSubject();
    }
}
