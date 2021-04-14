package com.roms.componentprocessing.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="ReturnRequests")
public class ReturnRequest {
    @Id
    private String requestId;
    private String userName;
    private long contactNumber;
    private long cardNumber;
    private boolean isPriorityRequest;

    private String componentType;
    private String componentName;
    private int quantity;

    private double processingCharge;
    private double packageAndDeliveryCharge;
    private Date dateOfDelivery;

}
