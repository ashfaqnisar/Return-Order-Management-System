package com.returnorder.componentprocessing.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service")
public interface AuthFeignClient {

    @GetMapping(value = "/validate")
    Boolean validateToken(@RequestHeader("Authorization") String token);

}