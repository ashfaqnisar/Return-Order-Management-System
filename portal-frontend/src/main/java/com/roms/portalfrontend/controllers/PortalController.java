package com.roms.portalfrontend.controllers;

import com.roms.portalfrontend.payload.LoginUserRequestPayload;
import com.roms.portalfrontend.payload.ReturnRequestPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PortalController {
    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

//    @GetMapping("/test")
//    public String testPage() {
//        return "testLogin";
//    }

//    @PostMapping("/processLogin")
//    public String getUserDetails(LoginUserRequestPayload loginUserRequestPayload) {
//        log.info(loginUserRequestPayload.toString());
//        return "redirect:/";
//    }

//    @PostMapping("/processReturn")
//    public String createReturnProcess(ReturnRequestPayload returnRequestPayload) {
//        return "redirect:payment";
//    }

}
