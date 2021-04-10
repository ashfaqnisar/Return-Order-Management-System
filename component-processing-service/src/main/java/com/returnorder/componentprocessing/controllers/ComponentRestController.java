package com.returnorder.componentprocessing.controllers;

import com.returnorder.componentprocessing.entity.ReturnRequest;
import com.returnorder.componentprocessing.feignClients.AuthFeignClient;
import com.returnorder.componentprocessing.feignClients.PaymentFeignClient;
import com.returnorder.componentprocessing.payload.ReturnRequestPayload;
import com.returnorder.componentprocessing.payload.PaymentResponse;
import com.returnorder.componentprocessing.payload.ReturnResponsePayload;
import com.returnorder.componentprocessing.services.ReturnProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ComponentRestController {
    private final PaymentFeignClient paymentFeignClient;
    private final AuthFeignClient authFeignClient;

    private final ReturnProcessService returnProcessService;

    @Autowired
    public ComponentRestController(PaymentFeignClient paymentFeignClient, AuthFeignClient authFeignClient, ReturnProcessService returnProcessService) {
        this.paymentFeignClient = paymentFeignClient;
        this.authFeignClient = authFeignClient;
        this.returnProcessService = returnProcessService;
    }

    @PostMapping("/returns")
    public ReturnResponsePayload createReturnRequest(@RequestHeader("Authorization") String token,
                                                     @RequestBody ReturnRequestPayload returnRequestPayload) {
        authFeignClient.validateToken(token);
        return returnProcessService.processReturnRequest(returnRequestPayload);
    }

    @PostMapping("/payment/{requestId}/{cardNumber}/{processingCharge}")
    public String paymentForReturnRequest(
            @RequestHeader("Authorization") String token,
            @PathVariable("requestId") String requestId,
            @PathVariable("cardNumber") long cardNumber,
            @PathVariable("processingCharge") double processingCharge
    ) {
        authFeignClient.validateToken(token);
        return returnProcessService.makePayment(requestId, cardNumber, processingCharge);
    }

}
