package com.roms.portalfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PortalApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
