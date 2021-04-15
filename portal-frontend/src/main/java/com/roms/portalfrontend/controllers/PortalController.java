package com.roms.portalfrontend.controllers;

import com.roms.portalfrontend.payload.LoginUserRequest;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class PortalController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }
    @GetMapping("/test")
    public String testPage() {
        return "testLogin";
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

    @PostMapping("/login")
    public String getUserDetails(@ModelAttribute("loginUserRequest") LoginUserRequest loginUserRequest){
        log.info(loginUserRequest.toString());
        return "redirect:/";
    }

}
