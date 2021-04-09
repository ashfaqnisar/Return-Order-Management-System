package com.returnorder.componentprocessing.feignService;

import com.returnorder.componentprocessing.entities.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service")
public interface PaymentFeignClient {

    @GetMapping("/processPayment/{cardNumber}/{charge}")
    PaymentResponse getCurrentBalance(@PathVariable long cardNumber, @PathVariable double charge);

}
