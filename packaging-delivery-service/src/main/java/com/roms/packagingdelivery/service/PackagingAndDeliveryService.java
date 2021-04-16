package com.roms.packagingdelivery.service;

import org.springframework.stereotype.Service;

@Service
public class PackagingAndDeliveryService {
    private static final double PROTECTIVE_SHEATH = 50;
    private static final double PACKAGING_AND_DELIVERY_ACCESSORY = 150;
    private static final double PACKAGING_AND_DELIVERY_INTEGRAL = 300;

    public double getCharge(String componentType, int count) {
        if (componentType.equalsIgnoreCase("accessory")) {
            return (PACKAGING_AND_DELIVERY_ACCESSORY + PROTECTIVE_SHEATH) * count;
        }
        if (componentType.equalsIgnoreCase("integral"))
            return (PACKAGING_AND_DELIVERY_INTEGRAL + PROTECTIVE_SHEATH) * count;
        return 0;
    }
}
