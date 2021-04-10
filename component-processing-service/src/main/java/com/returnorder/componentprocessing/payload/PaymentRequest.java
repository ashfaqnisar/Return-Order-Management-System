package com.returnorder.componentprocessing.payload;

import lombok.Data;

@Data
public class PaymentRequest {
    private long cardNumber;
    private double charge;
}
