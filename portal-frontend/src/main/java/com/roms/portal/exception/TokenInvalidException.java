package com.roms.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Token not available")
public class TokenInvalidException extends RuntimeException {
    public TokenInvalidException() {

    }
    public TokenInvalidException(String message) {
        super(message);
    }

}
