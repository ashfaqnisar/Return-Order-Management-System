package com.returnorder.componentprocessing.payload;

import lombok.Data;

import java.util.Date;

@Data
public class ReturnResponsePayload {
    private String requestId;
    private double processingCharge;
    private double packageAndDeliveryCharge;
    private Date dateOfDelivery;
}
