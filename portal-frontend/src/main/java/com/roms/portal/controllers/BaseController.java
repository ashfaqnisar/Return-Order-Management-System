package com.roms.portal.controllers;

import com.roms.portal.service.PortalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class BaseController {
    private final PortalService portalService;

    @Autowired
    public BaseController(PortalService portalService) {
        this.portalService = portalService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @GetMapping("/")
    public String homePage(HttpSession session) {
        portalService.checkTokenInSession(session);
        return "home.html";
    }

    @PostMapping("/confirmReturnRequest")
    public String confirmReturnRequest() {
        return "redirect:/payment";
    }

    @PostMapping("/goToHome")
    public String goToHome() {
        return "redirect:/";
    }

    @PostMapping("/goToPayment")
    public String goToPayment() {
        return "redirect:/payment";
    }

    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout=true";
    }


}
