package com.returnorder.componentprocessing.feignClients;

import com.returnorder.componentprocessing.payload.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service")
public interface PaymentFeignClient {

    @GetMapping("/payments/process/{cardNumber}/{charge}")
    PaymentResponse getCurrentBalance(@PathVariable long cardNumber, @PathVariable double charge);

}
