package com.roms.packagingdelivery.controller;

import com.roms.packagingdelivery.service.PackagingAndDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packagingAndDelivery")
public class PackagingDeliveryController {

    public PackagingAndDeliveryService packagingAndDeliveryService;

    @Autowired
    public PackagingDeliveryController(PackagingAndDeliveryService packagingAndDeliveryService) {
        this.packagingAndDeliveryService = packagingAndDeliveryService;
    }

    @GetMapping("/getCharge/{componentType}/{count}")
    public double getPackagingAndDeliveryCharge(@PathVariable String componentType, @PathVariable int count) {
        return packagingAndDeliveryService.getCharge(componentType, count);
    }
}
