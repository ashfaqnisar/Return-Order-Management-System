package com.roms.portalfrontend.controllers;

import com.roms.portalfrontend.AuthResponsePayload;
import com.roms.portalfrontend.feignClient.AuthFeignClient;
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

    @Autowired
    public PortalController(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
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
}
