package com.returnorder.authentication.controller;

import com.returnorder.authentication.exception.TokenInvalidException;
import com.returnorder.authentication.payload.JwtResponse;
import com.returnorder.authentication.payload.LoginRequest;
import com.returnorder.authentication.security.jwt.JwtHandler;
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
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtHandler jwtHandler;

    public AuthController(AuthenticationManager authManager, JwtHandler jwtHandler) {
        this.authManager = authManager;
        this.jwtHandler = jwtHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtHandler.generateJwtToken(authentication);
        return new ResponseEntity<>(new JwtResponse(jwt), HttpStatus.OK);
    }

    @GetMapping("/validate")
    public boolean validateAndReturnUser(@RequestHeader("Authorization") String token) throws TokenInvalidException {
        return jwtHandler.validateJwtToken(token);
    }
}
