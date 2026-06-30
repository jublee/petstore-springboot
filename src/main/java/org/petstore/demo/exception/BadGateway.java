package org.petstore.demo.exception;

public class BadGateway extends ApiException {
    public BadGateway(String message) {
        super(message);
    }
}
