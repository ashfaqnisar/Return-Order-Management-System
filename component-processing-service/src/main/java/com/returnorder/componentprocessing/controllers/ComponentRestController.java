package com.returnorder.componentprocessing.controllers;

import com.returnorder.componentprocessing.feignClients.PaymentFeignClient;
import com.returnorder.componentprocessing.payload.PaymentRequest;
import com.returnorder.componentprocessing.payload.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ComponentRestController {
    private final PaymentFeignClient paymentFeignClient;

    @Autowired
    public ComponentRestController(PaymentFeignClient paymentFeignClient) {
        this.paymentFeignClient = paymentFeignClient;
    }

    @GetMapping("/payment")
    public PaymentResponse getPaymentResponse(@RequestBody PaymentRequest paymentRequest) {
        return paymentFeignClient.getCurrentBalance(paymentRequest.getCardNumber(), paymentRequest.getCharge());
    }
}
