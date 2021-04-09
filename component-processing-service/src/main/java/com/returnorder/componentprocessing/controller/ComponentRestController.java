package com.returnorder.componentprocessing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ComponentRestController {
    @GetMapping("/test")
    public String sendHelloWorld() {
        log.debug("Inside the hello world");
        return "Hello world";
    }
}
