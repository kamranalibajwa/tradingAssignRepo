package com.trading.assignment.exception;


public class ExResponse {

    private String url;
    private String message;
    private String statusCode;

    public ExResponse(String url, String message, String code) {
        this.url = url;
        this.message = message;
        this.statusCode = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
