package com.roms.portalfrontend.feignClient;

import com.roms.portalfrontend.payload.ReturnRequestPayload;
import com.roms.portalfrontend.payload.ReturnResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "component-processing-service", url = "http://localhost:8081")
public interface ReturnFeignClient {
    @PostMapping("/returns/createReturnRequest")
    ReturnResponsePayload createReturnRequest(
            @RequestHeader("Authorization") String token,
            ReturnRequestPayload returnRequestPayload
    );

    @PostMapping("/paymentForReturn/{requestId}/{cardNumber}/{processingCharge}")
    String makePaymentForReturnRequest(@PathVariable String requestId, @PathVariable long cardNumber, @PathVariable double processingCharge);

}
