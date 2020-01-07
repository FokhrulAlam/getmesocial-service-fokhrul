package com.fokhrul.mobileappws.ui.model.response;
/**
 * This is the class whose object will be passed incase of any error.
 */

import java.util.Date;

public class ErrorMessage {
    private Date timestamp;
    private String message;

    /**
     * default constructor
     */
    public ErrorMessage() {
    }

    /**
     * Parameterized constructor
     * @param timestamp provides the current time
     * @param message   provides the custom error message
     */
    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
