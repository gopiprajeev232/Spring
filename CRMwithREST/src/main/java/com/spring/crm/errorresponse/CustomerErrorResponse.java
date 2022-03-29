package com.spring.crm.errorresponse;

import lombok.Data;

@Data
public class CustomerErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public CustomerErrorResponse() {

    }

    public CustomerErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
