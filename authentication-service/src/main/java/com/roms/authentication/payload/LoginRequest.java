package com.roms.authentication.payload;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
