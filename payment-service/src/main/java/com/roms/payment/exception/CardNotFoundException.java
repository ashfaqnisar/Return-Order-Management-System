package com.roms.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No, Card Number available with this  card number")
public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(long cardNumber) {
        super("There is no card present with this " + cardNumber + " card number");
    }
}
