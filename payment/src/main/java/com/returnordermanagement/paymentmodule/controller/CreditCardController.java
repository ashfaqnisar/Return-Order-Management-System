package com.returnordermanagement.paymentmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanagement.paymentmodule.exception.CardNotFoundException;
import com.returnordermanagement.paymentmodule.service.CreditCardService;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/creditcard/{cardNumber}/{charge}")
    public double getBalance(@PathVariable long cardNumber, @PathVariable double charge) throws CardNotFoundException {
        try {
            return creditCardService.processPayment(cardNumber, charge);
        } catch (CardNotFoundException cfx) {
            throw new CardNotFoundException("Card Details Not Found");
        }
    }
}
