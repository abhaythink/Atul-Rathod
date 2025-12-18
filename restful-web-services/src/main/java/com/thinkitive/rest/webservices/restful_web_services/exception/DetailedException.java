package com.thinkitive.rest.webservices.restful_web_services.exception;

import java.sql.Timestamp;
import java.time.LocalDate;

public class DetailedException {
    private LocalDate timestamp;
    private String message;
    private String description;

    public DetailedException(LocalDate timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
