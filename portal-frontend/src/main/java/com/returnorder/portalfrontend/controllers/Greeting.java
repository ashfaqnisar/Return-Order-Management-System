package com.returnorder.portalfrontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class Greeting {
    @GetMapping("greeting")
    public String greeting(Map<String, Object> model) {
        model.put("message", "Greetings Ashfaq");
        return "greeting";
    }
}
