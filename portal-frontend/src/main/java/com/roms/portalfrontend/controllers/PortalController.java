package com.roms.portalfrontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }
    @GetMapping("/test")
    public String testPage() {
        return "test";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }

    @GetMapping("/failure")
    public String failurePage() {
        return "failure";
    }

    @GetMapping("/payment")
    public String paymentPage() {
        return "payment";
    }

    @GetMapping("/confirmation")
    public String confirmationPage() {
        return "confirmation";
    }

}
