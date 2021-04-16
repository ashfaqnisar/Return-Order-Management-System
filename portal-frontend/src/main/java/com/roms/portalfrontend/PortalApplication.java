package com.roms.portalfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PortalApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
