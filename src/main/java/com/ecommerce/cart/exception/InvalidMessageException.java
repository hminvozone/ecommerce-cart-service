package com.ecommerce.cart.exception;

public class InvalidMessageException extends RuntimeException {
    private final String exceptionMessage;

    public InvalidMessageException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public InvalidMessageException(String exceptionMessage, Exception ex) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
