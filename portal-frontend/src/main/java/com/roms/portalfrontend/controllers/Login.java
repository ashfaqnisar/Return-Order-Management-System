package com.roms.portalfrontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
    @GetMapping("/")
    public String loginPage() {
        return "home";
    }
    @GetMapping("/login")
    public String loginPage2() {
        return "login";
    }

    @GetMapping("/confirmation")
    public String loginPage1() {
        return "confirmation";
    }

    @GetMapping("/failure")
    public String loginPage11() {
        return "failure";
    }

    @GetMapping("/payment")
    public String loginPage111() {
        return "payment";
    }

    @GetMapping("/process")
    public String loginPage1112() {
        return "process";
    }

}
