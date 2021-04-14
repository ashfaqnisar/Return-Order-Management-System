package com.returnorder.payment.controller;

import com.returnorder.payment.payload.PaymentResponse;
import com.returnorder.payment.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class CreditCardController {
    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/process/{cardNumber}/{charge}")
    public ResponseEntity<PaymentResponse> getBalance(
            @PathVariable long cardNumber,
            @PathVariable double charge
    ) {
        return new ResponseEntity<>(
                new PaymentResponse(creditCardService.processPayment(cardNumber, charge)),
                HttpStatus.OK
        );

    }
}
