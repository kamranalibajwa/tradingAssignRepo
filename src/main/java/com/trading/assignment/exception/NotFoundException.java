package com.trading.assignment.exception;

public class NotFoundException extends RuntimeException {

    private final String errorMessage;

    public NotFoundException() {
        errorMessage = null;
    }

    public NotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
