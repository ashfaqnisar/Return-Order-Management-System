package com.roms.portal.payload;

import lombok.Data;

@Data
public class ReturnRequestPayload {
    private String userName;
    private long contactNumber;
    private long cardNumber;
    private Boolean isPriorityRequest = false;
    private String componentType;
    private String componentName;
    private int quantity;
}
