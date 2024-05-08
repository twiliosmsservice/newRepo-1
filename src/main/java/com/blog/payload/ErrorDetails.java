package com.blog.payload; // Payload used for takes data from postman and it gives the data backs to postman.

import java.util.Date;

public class ErrorDetails {  // This class is used for to send response message
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp , String message,String details) {   // This is contructor.This constructor is used for setters.
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
