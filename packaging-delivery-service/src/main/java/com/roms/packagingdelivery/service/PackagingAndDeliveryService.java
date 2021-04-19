package com.roms.packagingdelivery.service;

import com.roms.packagingdelivery.exception.ComponentTypeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PackagingAndDeliveryService {
    private static final double PROTECTIVE_SHEATH = 50;
    private static final double PACKAGING_AND_DELIVERY_ACCESSORY = 150;
    private static final double PACKAGING_AND_DELIVERY_INTEGRAL = 300;

    public double getCharge(String componentType, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count must be greater than zero");
        }

        if (componentType.equalsIgnoreCase("accessory")) {
            return (PACKAGING_AND_DELIVERY_ACCESSORY + PROTECTIVE_SHEATH) * count;
        } else if (componentType.equalsIgnoreCase("integral"))
            return (PACKAGING_AND_DELIVERY_INTEGRAL + PROTECTIVE_SHEATH) * count;
        else
            throw new ComponentTypeNotFoundException("There is no delivery charge with this component type");
    }
}
