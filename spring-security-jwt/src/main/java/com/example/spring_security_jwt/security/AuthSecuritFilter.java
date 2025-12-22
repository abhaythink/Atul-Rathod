package com.example.spring_security_jwt.security;

import com.example.spring_security_jwt.entity.User;
import com.example.spring_security_jwt.repo.UserRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthSecuritFilter extends OncePerRequestFilter {
    private final SecurityUtility securityUtility;
    private final UserRepo userRepo;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.debug("AuthSecuritFilter request {}",request.getRequestURI());

        String getTokenHeader=request.getHeader("Authentication");
        if (getTokenHeader == null || !getTokenHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        String bearerToken=getTokenHeader.split("Bearer")[1];
        String username=securityUtility.getUsernamefromToken(bearerToken);
        if (username !=null && SecurityContextHolder.getContext().getAuthentication()==null){
            User user=userRepo.findByUsername(username).orElseThrow();
            UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(user,null,null);
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        filterChain.doFilter(request,response);
    }
}
