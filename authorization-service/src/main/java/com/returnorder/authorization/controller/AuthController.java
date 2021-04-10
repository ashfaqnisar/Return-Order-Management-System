package com.returnorder.authorization.controller;

import com.returnorder.authorization.exception.TokenInvalidException;
import com.returnorder.authorization.payload.JwtResponse;
import com.returnorder.authorization.payload.LoginRequest;
import com.returnorder.authorization.security.jwt.JwtHandler;
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
