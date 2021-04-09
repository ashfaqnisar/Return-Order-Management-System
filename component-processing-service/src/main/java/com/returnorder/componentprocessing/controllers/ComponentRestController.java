package com.returnorder.componentprocessing.controllers;

import com.returnorder.componentprocessing.entities.PaymentResponse;
import com.returnorder.componentprocessing.feignService.PaymentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public PaymentResponse getPaymentResponse() {
        return paymentFeignClient.getCurrentBalance(1234123412, 1000);
    }
}
