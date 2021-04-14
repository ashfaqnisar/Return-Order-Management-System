package com.returnorder.componentprocessing.controllers;

import com.returnorder.componentprocessing.feignClients.AuthFeignClient;
import com.returnorder.componentprocessing.payload.ReturnRequestPayload;
import com.returnorder.componentprocessing.payload.ReturnResponsePayload;
import com.returnorder.componentprocessing.services.ReturnProcessService;
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

    @PostMapping("/paymentForReturn/{requestId}/{cardNumber}/{processingCharge}")
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
