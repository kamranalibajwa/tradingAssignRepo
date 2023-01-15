package com.trading.assignment.exception;

public class InvalidParamException extends RuntimeException {

    private final String errorMessage;

    public InvalidParamException() {
        errorMessage = null;
    }

    public InvalidParamException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
