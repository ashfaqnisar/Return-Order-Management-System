package com.roms.portalfrontend.controllers;

import com.roms.portalfrontend.payload.LoginUserRequestPayload;
import com.roms.portalfrontend.payload.ReturnRequestPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PortalController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
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

    @PostMapping("/[processLogin")
    public String getUserDetails(@ModelAttribute("loginUserRequest") LoginUserRequestPayload loginUserRequestPayload){
        log.info(loginUserRequestPayload.toString());
        return "redirect:/";
    }

    @PostMapping("/createReturnProcess")
    public String createReturnProcess(@ModelAttribute("returnRequestPayload") ReturnRequestPayload returnRequestPayload){
        return "redirect:payment";
    }

}
