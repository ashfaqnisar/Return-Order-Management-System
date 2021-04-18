package com.roms.payment.exception;

import java.util.Date;

public class ExceptionResponse {

    private Date timestamp;
    private String Message;
    private String details;

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return Message;
    }

    public String getDetails() {
        return details;
    }

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        Message = message;
        this.details = details;
    }

    @Override
    public String toString() {
        return "ExceptionResponse [timestamp=" + timestamp + ", Message=" + Message + ", details=" + details + "]";
    }


}
