package com.roms.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Request Id Not Available")
public class RequestIdNotFoundException extends RuntimeException {
    public RequestIdNotFoundException() {

    }

    public RequestIdNotFoundException(String message) {
        super(message);
    }

}
