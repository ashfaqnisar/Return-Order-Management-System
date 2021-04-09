package com.returnorder.componentprocessing.controllers;

import com.returnorder.componentprocessing.exceptions.TokenInvalidException;
import com.returnorder.componentprocessing.feignClients.AuthFeignClient;
import com.returnorder.componentprocessing.feignClients.PaymentFeignClient;
import com.returnorder.componentprocessing.payload.PaymentRequest;
import com.returnorder.componentprocessing.payload.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ComponentRestController {
    private final PaymentFeignClient paymentFeignClient;
    private final AuthFeignClient authFeignClient;

    @Autowired
    public ComponentRestController(PaymentFeignClient paymentFeignClient, AuthFeignClient authFeignClient) {
        this.paymentFeignClient = paymentFeignClient;
        this.authFeignClient = authFeignClient;
    }

    @GetMapping("/payment")
    public PaymentResponse getPaymentResponse(
            @RequestHeader("Authorization") String token,
            @RequestBody PaymentRequest paymentRequest) {
        log.debug("Inside the call");
        if (!authFeignClient.isValidToken(token)) {
            log.error("Invalid Token Passed");
            throw new TokenInvalidException("Invalid Token");
        }
        return paymentFeignClient.getCurrentBalance(paymentRequest.getCardNumber(), paymentRequest.getCharge());
    }
}
