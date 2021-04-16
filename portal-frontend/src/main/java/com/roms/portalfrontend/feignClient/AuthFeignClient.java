package com.roms.portalfrontend.feignClient;

import com.roms.portalfrontend.AuthResponsePayload;
import com.roms.portalfrontend.payload.UserLoginRequestPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service", url = "http://localhost:2222")
public interface AuthFeignClient {
    @PostMapping("/auth/login")
    AuthResponsePayload generateToken(UserLoginRequestPayload userLoginRequestPayload);

    @GetMapping(value = "/auth/validate")
    Boolean validateToken(@RequestHeader("Authorization") String token);

}
