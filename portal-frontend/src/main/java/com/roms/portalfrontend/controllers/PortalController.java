package com.roms.portalfrontend.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PortalController {
    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @GetMapping("/")
    public String homePage() {
        return "home.html";
    }
}
