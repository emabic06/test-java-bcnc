package com.bcnc.pricingapi.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends RuntimeException {

    private final HttpStatus status;
    private final String type;

    public DataNotFoundException(HttpStatus status, String type, String message) {
        super(message);
        this.status = status;
        this.type = type;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "DatabaseNotFoundException{" +
                "status=" + status +
                ", type='" + type + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
