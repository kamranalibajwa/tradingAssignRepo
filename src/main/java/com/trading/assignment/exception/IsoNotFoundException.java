package com.trading.assignment.exception;

public class IsoNotFoundException extends RuntimeException {

    private final String errorMessage;

    public IsoNotFoundException() {
        errorMessage = null;
    }

    public IsoNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
