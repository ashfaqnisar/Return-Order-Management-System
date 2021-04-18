package com.roms.portal.feignClient;

import com.roms.portal.payload.AuthResponsePayload;
import com.roms.portal.payload.UserLoginRequestPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service")
public interface AuthFeignClient {
    @PostMapping("/auth/login")
    AuthResponsePayload generateToken(UserLoginRequestPayload userLoginRequestPayload);

    @GetMapping(value = "/auth/validate")
    Boolean validateToken(@RequestHeader("Authorization") String token);

}
