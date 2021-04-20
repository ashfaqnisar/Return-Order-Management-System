package com.roms.payment.controller;

import com.roms.payment.payload.PaymentResponse;
import com.roms.payment.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final CreditCardService creditCardService;

    @Autowired
    public PaymentController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/process/{cardNumber}/{cvv}/{charge}")
    public ResponseEntity<PaymentResponse> getBalance(
            @PathVariable long cardNumber,
            @PathVariable double charge,
            @PathVariable int cvv
    ) {
        return new ResponseEntity<>(
                new PaymentResponse(creditCardService.processPayment(cardNumber, cvv, charge)),
                HttpStatus.OK
        );

    }
}
