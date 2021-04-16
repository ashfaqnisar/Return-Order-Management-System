package com.roms.authentication.controller;

import com.roms.authentication.exception.TokenInvalidException;
import com.roms.authentication.payload.AuthResponse;
import com.roms.authentication.payload.LoginRequest;
import com.roms.authentication.security.JwtHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtHandler jwtHandler;

    public AuthController(AuthenticationManager authManager, JwtHandler jwtHandler) {
        this.authManager = authManager;
        this.jwtHandler = jwtHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthResponse authResponse = jwtHandler.generateJwtToken(authentication);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @GetMapping("/validate")
    public boolean validateAndReturnUser(@RequestHeader("Authorization") String token) throws TokenInvalidException {
        return jwtHandler.validateJwtToken(token);
    }
}
