package com.roms.portalfrontend.payload;

import lombok.Data;

@Data
public class ReturnRequestPayload {
    private String userName;
    private long contactNumber;
    private long cardNumber;
    private boolean isPriorityRequest;

    private String componentType;
    private String componentName;
    private int quantity;
}
