package com.roms.portalfrontend.service;

import com.roms.portalfrontend.exception.RequestIdNotFoundException;
import com.roms.portalfrontend.exception.TokenInvalidException;
import com.roms.portalfrontend.feignClient.AuthFeignClient;
import com.roms.portalfrontend.payload.AuthResponsePayload;
import com.roms.portalfrontend.payload.ReturnResponsePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class PortalService {
    private final AuthFeignClient authFeignClient;

    @Autowired
    public PortalService(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    /*
     * Checks the session for the user object is present or not and returns the authResponse.
     * */
    public AuthResponsePayload checkTokenInSession(HttpSession session) {
        try {
            AuthResponsePayload response = (AuthResponsePayload) session.getAttribute("user");
            authFeignClient.validateToken(response.getToken());
            return response;
        } catch (Exception e) {
            throw new TokenInvalidException("Token Expired or Not Available");
        }
    }


    /*
     * Checks for the requestId in the ReturnResponsePayload and returns it
     * */
    public String checkForRequestIdInPayload(ReturnResponsePayload response) {
        try {
            return response.getRequestId();
        } catch (Exception e) {
            throw new RequestIdNotFoundException("Request Id Not Found");
        }
    }
}
