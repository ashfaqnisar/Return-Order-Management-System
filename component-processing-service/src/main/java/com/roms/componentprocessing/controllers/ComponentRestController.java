package com.roms.componentprocessing.controllers;

import com.roms.componentprocessing.clients.AuthFeignClient;
import com.roms.componentprocessing.payload.PaymentResponse;
import com.roms.componentprocessing.payload.ReturnRequestPayload;
import com.roms.componentprocessing.payload.ReturnResponsePayload;
import com.roms.componentprocessing.services.ReturnProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/returns")
public class ComponentRestController {
    private final AuthFeignClient authFeignClient;

    private final ReturnProcessService returnProcessService;

    @Autowired
    public ComponentRestController(AuthFeignClient authFeignClient, ReturnProcessService returnProcessService) {
        this.authFeignClient = authFeignClient;
        this.returnProcessService = returnProcessService;
    }

    @PostMapping("/createReturnRequest")
    public ReturnResponsePayload createReturnRequest(@RequestHeader("Authorization") String token,
                                                     @RequestBody ReturnRequestPayload returnRequestPayload) {
        authFeignClient.validateToken(token);
        return returnProcessService.processReturnRequest(returnRequestPayload);
    }

    @PostMapping("/paymentForReturn/{requestId}/{cardNumber}/{cvv}/{processingCharge}")
    public PaymentResponse paymentForReturnRequest(
            @RequestHeader("Authorization") String token,
            @PathVariable("requestId") String requestId,
            @PathVariable("cardNumber") long cardNumber,
            @PathVariable("cvv") int cvv,
            @PathVariable("processingCharge") double processingCharge
    ) {
        authFeignClient.validateToken(token);
        return returnProcessService.makePayment(requestId, cardNumber, cvv ,processingCharge);
    }

}
