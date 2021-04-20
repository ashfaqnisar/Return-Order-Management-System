package com.roms.componentprocessing.clients;

import com.roms.componentprocessing.payload.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service")
public interface PaymentFeignClient {

    @GetMapping("/payments/process/{cardNumber}/{cvv}/{charge}")
    PaymentResponse getCurrentBalance(@PathVariable long cardNumber, @PathVariable int cvv,
                                      @PathVariable double charge);

}
