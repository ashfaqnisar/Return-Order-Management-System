package com.roms.portalfrontend.controllers;

import com.roms.portalfrontend.AuthResponsePayload;
import com.roms.portalfrontend.feignClient.AuthFeignClient;
import com.roms.portalfrontend.feignClient.ReturnFeignClient;
import com.roms.portalfrontend.payload.ReturnRequestPayload;
import com.roms.portalfrontend.payload.ReturnResponsePayload;
import com.roms.portalfrontend.payload.UserLoginRequestPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class PortalController {
    private final AuthFeignClient authFeignClient;
    private final ReturnFeignClient returnFeignClient;

    private ReturnResponsePayload returnResponsePayload;

    @Autowired
    public PortalController(AuthFeignClient authFeignClient, ReturnFeignClient returnFeignClient) {
        this.authFeignClient = authFeignClient;
        this.returnFeignClient = returnFeignClient;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @GetMapping("/")
    public String homePage(HttpSession session) {
        try {
            AuthResponsePayload response = (AuthResponsePayload) session.getAttribute("user");
            authFeignClient.validateToken(response.getToken());
            return "home.html";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/processLogin")
    public String processLogin(UserLoginRequestPayload userLoginRequestPayload, HttpSession session) {
        try {
            log.info(userLoginRequestPayload.toString());
            AuthResponsePayload authResponsePayload = authFeignClient.generateToken(userLoginRequestPayload);
            session.setAttribute("user", authResponsePayload);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/login?error=true";
        }
    }


    @PostMapping("/processReturnRequest")
    public String processReturnRequest(ReturnRequestPayload returnRequestPayload, HttpSession session) {
        try {
            log.info(returnRequestPayload.toString());

            AuthResponsePayload authResponsePayload = (AuthResponsePayload) session.getAttribute("user");
            returnResponsePayload = returnFeignClient.createReturnRequest(authResponsePayload.getToken(), returnRequestPayload);
            return "/payment.html";
        } catch (NullPointerException e) {
            return "redirect:/login";
        } catch (Exception e) {
            log.info(e.getMessage());
            return "redirect:/?retry=true";
        }
    }
}
